package per.th;

import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Arrays;
import java.util.Collections;
import java.util.Objects;
import java.util.concurrent.Executors;

/**
 * <p>info:
 * <p>[EN]
 * <p>[CN]
 * <p>mail: 614924638@qq.com
 * <p>time: 2017/5/4  19:43
 *
 * @author TH
 * @since 1.0.0
 */
public class UtilsGenerator {

    public static String getParams(Method item) {
        Class<?>[] classes = item.getParameterTypes();
        if(classes.length == 0) return "";
        String res = classes[0].getSimpleName() + " arg0";
        for(int i = 1; i < classes.length; i++) {
            res += ", " + classes[i].getSimpleName() + " arg" + i;
        }
        return res;
    }

    public static String get(String str) {
        String res = "";
        boolean b = true;
        for(String item : str.split(" ")) {
            if(b=!b) res += item + " ";
        }
        if(res.length() > 0) res = res.substring(0, res.length()-1);
        return res;
    }

    public static String getCode(Class clazz, Method item) {
        StringBuilder sb = new StringBuilder();
        sb.append("    public static " + item.getReturnType().getSimpleName()+" "+item.getName()+"("+ getParams(item) +") {\n");
        sb.append("        " + (item.getReturnType() == void.class ? "" : "return ") + clazz.getName() + "." + item.getName() + "(" + get(getParams(item)) + ");\n" );
        sb.append("    }\n\n");
        return sb.toString();
    }

    public static void write(Class<?> clazz) throws IOException {
        String code = "import per.th.comlib.Utils;\n\n";
        code += "class " + clazz.getSimpleName() + " extends Utils {\n\n";
        Method[] m = clazz.getMethods();
        for(Method item : m) {
            if(!Modifier.isStatic(item.getModifiers())) continue;
            code += getCode(clazz, item);
        }
        code += "}";
        FileOutputStream out = new FileOutputStream("java/"+clazz.getSimpleName()+".java");
        out.write(code.getBytes());
        out.close();
    }

    public static void main(String[] args) throws IOException {
        Class<?>[] clazz = {Objects.class, Arrays.class, Collections.class, Executors.class};
        for(Class<?> item : clazz) {
            write(item);
        }
    }

}
