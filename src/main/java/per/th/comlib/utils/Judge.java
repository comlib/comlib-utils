package per.th.comlib.utils;

import per.th.comlib.Utils;

import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.util.Collection;
import java.util.Map;

/**
 * <p>info: Judge
 *      [CN]对于对象值的各种情况判断，通常用于简化程序if操作</pre>
 * <p>mail: 614924638@qq.com
 * <p>time: 2017/5/5  9:28
 *
 * @author TH
 * @since 1.0.0
 */
public class Judge extends Utils {

    public static boolean isNull(Object value) {
        return null == value;
    }

    public static boolean isNull(Object arg0, Object arg1) {
        return isNull(arg0) && isNull(arg1);
    }

    public static boolean isNull(Object arg0, Object arg1, Object arg2) {
        return isNull(arg0, arg1) && isNull(arg2);
    }

    /** @throws NullPointerException if args is null of array type */
    public static boolean isNull(Object arg0, Object... args) {
        assert null == args : "args cannot be null";
        boolean res = isNull(arg0);
        for(Object item : args) {
            res &= isNull(item);
            if(!res) return false;
        }
        return res;
    }


    public static boolean notNull(Object value) {
        return !isNull(value);
    }

    public static boolean notNull(Object arg0, Object arg1) {
        return !isNull(arg0, arg1);
    }

    public static boolean notNull(Object arg0, Object arg1, Object arg2) {
        return !isNull(arg0, arg1, arg2);
    }

    /** @throws NullPointerException if args is null of array type */
    public static boolean notNull(Object arg0, Object... args) {
        assert null == args : "args cannot be null";
        return !isNull(arg0, args);
    }


    public static boolean equals(Object arg0, Object arg1) {
        return notNull(arg0) && arg0.equals(arg1);
    }

    public static boolean equals(Object arg0, Object arg1, Object arg2) {
        return notNull(arg0) && arg0.equals(arg1) && arg0.equals(arg2);
    }

    /** @throws NullPointerException if args is null of array type */
    public static boolean equals(Object arg0, Object... args) {
        assert null == args : "args cannot be null";
        boolean res = notNull(arg0);
        for(Object item : args) {
            if(!res) return false;
            res &= arg0.equals(item);
        }
        return res;
    }


    public static boolean isArray(Object array) {
        return notNull(array) && array.getClass().isArray();
    }

    public static boolean isArray(Object arg0, Object arg1) {
        return isArray(arg0) && isArray(arg1);
    }

    public static boolean isArray(Object arg0, Object arg1, Object arg2) {
        return isArray(arg0, arg1) && isArray(arg2);
    }

    /** @throws NullPointerException if args is null of array type */
    public static boolean isArray(Object arg0, Object... args) {
        assert null == args : "args cannot be null";
        boolean res = isArray(arg0);
        for(Object item : args) {
            if(!res) return false;
            res &= isArray(item);
        }
        return res;
    }


    public static boolean isPrimitiveArray(Object array) {
        return isArray(array) && !(array instanceof Object[]);
    }

    public static boolean isPrimitiveArray(Object arg0, Object arg1) {
        return isPrimitiveArray(arg0) && isPrimitiveArray(arg1);
    }

    public static boolean isPrimitiveArray(Object arg0, Object arg1, Object arg2) {
        return isPrimitiveArray(arg0, arg1) && isPrimitiveArray(arg2);
    }

    /** @throws NullPointerException if args is null of array type */
    public static boolean isPrimitiveArray(Object arg0, Object... args) {
        assert null == args : "args cannot be null";
        boolean res = isPrimitiveArray(arg0);
        for(Object item : args) {
            if(!res) return false;
            res &= isPrimitiveArray(item);
        }
        return res;
    }


    public static boolean isEmpty(Object array) {
        return isArray(array) && Array.getLength(array) < 1;
    }

    public static boolean isEmpty(Object arg0, Object arg1) {
        return isEmpty(arg0) && isEmpty(arg1);
    }

    public static boolean isEmpty(Object arg0, Object arg1, Object arg2) {
        return isEmpty(arg0, arg1) && isEmpty(arg2);
    }

    /** @throws NullPointerException if args is null of array type */
    public static boolean isEmpty(Object arg0, Object... args) {
        assert null == args : "args cannot be null";
        boolean res = isEmpty(arg0);
        for(Object item : args) {
            if(!res) return false;
            res &= isEmpty(item);
        }
        return res;
    }


    public static boolean hasLengthArray(Object array) {
        return !isEmpty(array);
    }

    public static boolean hasLengthArray(Object arg0, Object arg1) {
        return hasLengthArray(arg0) && hasLengthArray(arg1);
    }

    public static boolean hasLengthArray(Object arg0, Object arg1, Object arg2) {
        return hasLengthArray(arg0, arg1) && hasLengthArray(arg2);
    }

    /** @throws NullPointerException if args is null of array type */
    public static boolean hasLengthArray(Object arg0, Object... args) {
        assert null == args : "args cannot be null";
        boolean res = hasLengthArray(arg0);
        for(Object item : args) {
            if(!res) return false;
            res &= hasLengthArray(item);
        }
        return res;
    }


    public static boolean hasElement(Object array) {
        if(!isArray(array)) { return false; }
        int l = Array.getLength(array);
        for(int i = 0; i < l; i++) {
            Object elem = Array.get(array, i);
            if(notNull(elem)) {
                return true;
            }
        }
        return false;
    }

    public static boolean hasElement(Object arg0, Object arg1) {
        return hasElement(arg0) && hasElement(arg1);
    }

    public static boolean hasElement(Object arg0, Object arg1, Object arg2) {
        return hasElement(arg0, arg1) && hasElement(arg2);
    }

    /** @throws NullPointerException if args is null of array type */
    public static boolean hasElement(Object arg0, Object... args) {
        assert null == args : "args cannot be null";
        boolean res = hasElement(arg0);
        for(Object item : args) {
            if(!res) return false;
            res &= hasElement(item);
        }
        return res;
    }


    /**
     * Determines whether the array contains elements.
     * -- can not determine @{code null} element
     * @param array Determine the array
     * @param element Determine the element
     * @return return Returns true if it contains, false otherwise
     */
    public static boolean contain(Object array, Object element) {
        if(!isArray(array) || isNull(element)) {
            return false;
        }
        int l = Array.getLength(array);
        for(int i = 0; i < l; i++) {
            Object item = Array.get(array, i);
            if(element.equals(item)) {
                return true;
            }
        }
        return false;
    }

    public static boolean contain(Object array, Object elem0, Object elem1) {
        return contain(array, elem0) && contain(array, elem1);
    }

    /** @throws NullPointerException if args is null of array type */
    public static boolean contain(Object array, Object elem0, Object... args) {
        assert null == args : "args cannot be null";
        boolean res = contain(array, elem0);
        for(Object item : args) {
            if(!res) return false;
            res &= contain(array, item);
        }
        return res;
    }

    
    public static boolean hasNullElement(Object array) {
        if(isNull(array)) return true;
        if(!isArray(array)) return false;
        int l = Array.getLength(array);
        for(int i = 0; i < l; i++) {
            Object elem = Array.get(array, i);
            if(isNull(elem)) {
                return true;
            }
        }
        return false;
    }

    public static boolean hasNullElement(Object arg0, Object arg1) {
        return hasNullElement(arg0) && hasNullElement(arg1);
    }

    public static boolean hasNullElement(Object arg0, Object arg1, Object arg2) {
        return hasNullElement(arg0, arg1) && hasNullElement(arg2);
    }

    /** @throws NullPointerException if args is null of array type */
    public static boolean hasNullElement(Object arg0, Object... args) {
        assert null == args : "args cannot be null";
        boolean res = hasNullElement(arg0);
        for(Object item : args) {
            if(!res) return false;
            res &= hasNullElement(item);
        }
        return res;
    }


    public static boolean noNullElement(Object array) {
        return !hasNullElement(array);
    }

    public static boolean noNullElement(Object arg0, Object arg1) {
        return !hasNullElement(arg0, arg1);
    }

    public static boolean noNullElement(Object arg0, Object arg1, Object arg2) {
        return !hasNullElement(arg0, arg1, arg2);
    }

    /** @throws NullPointerException if args is null of array type */
    public static boolean noNullElement(Object arg0, Object... args) {
        assert null == args : "args cannot be null";
        return !hasNullElement(arg0, args);
    }


    public static boolean isPrimitiveObject(Object value) {
        if(isNull(value)) { return false; }

        Field field = null;
        Class<?> clazz = value.getClass();
        try { field = clazz.getField("TYPE"); }
        catch (NoSuchFieldException e) { return false; }
        Class<?> fieldClass = field.getType();
        return fieldClass.isPrimitive();
    }

    public static boolean isPrimitiveObject(Object arg0, Object arg1) {
        return isPrimitiveObject(arg0) && isPrimitiveObject(arg1);
    }

    public static boolean isPrimitiveObject(Object arg0, Object arg1, Object arg2) {
        return isPrimitiveObject(arg0, arg1) && isPrimitiveObject(arg2);
    }

    /** @throws NullPointerException if args is null of array type */
    public static boolean isPrimitiveObject(Object arg0, Object... args) {
        assert null == args : "args cannot be null";
        boolean res = isPrimitiveObject(arg0);
        for(Object item : args) {
            if(!res) return false;
            res &= isPrimitiveObject(item);
        }
        return res;
    }


    public static boolean isNumber(Object value) {
        return value instanceof Number;
    }

    public static boolean isNumber(Object arg0, Object arg1) {
        return isNumber(arg0) && isNumber(arg1);
    }

    public static boolean isNumber(Object arg0, Object arg1, Object arg2) {
        return isNumber(arg0, arg1) && isNumber(arg2);
    }

    /** @throws NullPointerException if args is null of array type */
    public static boolean isNumber(Object arg0, Object... args) {
        assert null == args : "args cannot be null";
        boolean res = isNumber(arg0);
        for(Object item : args) {
            if(!res) return false;
            res &= isNumber(item);
        }
        return res;
    }


    public static boolean isDecimal(Object value) {
        return value instanceof Double || value instanceof Float;
    }

    public static boolean isDecimal(Object arg0, Object arg1) {
        return isDecimal(arg0) && isDecimal(arg1);
    }

    public static boolean isDecimal(Object arg0, Object arg1, Object arg2) {
        return isDecimal(arg0, arg1) && isDecimal(arg2);
    }

    /** @throws NullPointerException if args is null of array type */
    public static boolean isDecimal(Object arg0, Object... args) {
        assert null == args : "args cannot be null";
        boolean res = isDecimal(arg0);
        for(Object item : args) {
            if(!res) return false;
            res &= isDecimal(item);
        }
        return res;
    }

    // TODO: 17-5-13 method overload
    public static boolean isInteger(Object value) {
        return !isDecimal(value) && !(value instanceof Boolean);
    }

    public static boolean isNegative(double number) {
        return number < 0;
    }

    public static boolean isPositive(double number) {
        return number > 0;
    }

    public static boolean between(double value, double start, double to) {
        return value >= start && value < to;
    }

    public static boolean except(double value, double start, double to) {
        return !between(value, start, to);
    }

    public static boolean in(double value, double... values) {
        for(double item : values) {
            if(value == item) {
                return true;
            }
        }
        return false;
    }

    public static boolean is(boolean status) {
        return status;
    }

    public static boolean not(boolean status) {
        return !status;
    }

    public static boolean hasTrue(boolean arg0, boolean... args) {
        return or(arg0, args);
    }

    public static boolean hasFalse(boolean arg0, boolean... args) {
        return !and(arg0, args);
    }

    public static boolean allTrue(boolean arg0, boolean... args) {
        return and(arg0, args);
    }

    public static boolean allFalse(boolean arg0, boolean... args) {
        return !or(arg0, args);
    }

    public static boolean and(boolean arg0, boolean... args) {
        boolean res = arg0;
        for(boolean item : args) {
            res &= item;
            if(!res) break;
        }
        return res;
    }

    public static boolean or(boolean arg0, boolean... args) {
        boolean res = arg0;
        for(boolean item : args) {
            res |= item;
            if(res) break;
        }
        return res;
    }

    public static boolean xor(boolean bool1, boolean bool2) {
        return bool1 == bool2;
    }

    /** @throws NullPointerException if args is null of array type */
    public static boolean xor(boolean bool, boolean... args) {
        assert null == args : "args cannot be null";
        for(boolean item : args) {
            if(bool != item) {
                return false;
            }
        }
        return true;
    }


    public static boolean isEmpty(CharSequence seq) {
        return "".equals(seq);
    }

    public static boolean isEmpty(CharSequence arg0, CharSequence arg1) {
        return isEmpty(arg0) && isEmpty(arg1);
    }

    public static boolean isEmpty(CharSequence arg0, CharSequence arg1, CharSequence arg2) {
        return isEmpty(arg0, arg1) && isEmpty(arg2);
    }

    /** @throws NullPointerException if args is null of array type */
    public static boolean isEmpty(CharSequence arg0, CharSequence... args) {
        assert null == args : "args cannot be null";
        boolean res = isEmpty(arg0);
        for(CharSequence item : args) {
            if(!res) return false;
            res &= isEmpty(item);
        }
        return res;
    }

    public static boolean hasLength(CharSequence seq) {
        return notNull(seq) && seq.length() > 0;
    }

    public static boolean hasLength(CharSequence arg0, CharSequence arg1) {
        return hasLength(arg0) && hasLength(arg1);
    }

    public static boolean hasLength(CharSequence arg0, CharSequence arg1, CharSequence arg2) {
        return hasLength(arg0, arg1) && hasLength(arg2);
    }

    /** @throws NullPointerException if args is null of array type */
    public static boolean hasLength(CharSequence arg0, CharSequence... args) {
        assert null == args : "args cannot be null";
        boolean res = hasLength(arg0);
        for(CharSequence item : args) {
            if(!res) return false;
            res &= hasLength(item);
        }
        return res;
    }


    public static boolean hasText(CharSequence seq) {
        return hasLength(seq.toString().trim());
    }

    public static boolean hasText(CharSequence arg0, CharSequence arg1) {
        return hasText(arg0) && hasText(arg1);
    }

    public static boolean hasText(CharSequence arg0, CharSequence arg1, CharSequence arg2) {
        return hasText(arg0, arg1) && hasText(arg2);
    }

    /** @throws NullPointerException if args is null of array type */
    public static boolean hasText(CharSequence arg0, CharSequence... args) {
        assert null == args : "args cannot be null";
        boolean res = hasText(arg0);
        for(CharSequence item : args) {
            if(!res) return false;
            res &= hasText(item);
        }
        return res;
    }


    public static boolean contain(CharSequence seq, CharSequence sub) {
        return notNull(seq) && hasLength(sub) && seq.toString().contains(sub);
    }

    public static boolean contain(CharSequence seq, CharSequence sub0, CharSequence sub1) {
        return contain(seq, sub0) && contain(seq, sub1);
    }

    /** @throws NullPointerException if args is null of array type */
    public static boolean contain(CharSequence seq, CharSequence arg0, CharSequence... args) {
        assert null == args : "args cannot be null";
        boolean res = contain(seq, arg0);
        for(CharSequence item : args) {
            if(!res) return false;
            res &= contain(seq, item);
        }
        return res;
    }

    // TODO: 17-5-13 method overload
    public static boolean isNumber(CharSequence seq) {
        try { Double.parseDouble(seq.toString()); }
        catch (ClassCastException e) { return false; }
        return true;
    }

    public static boolean isBoolean(CharSequence seq) {
        return "true".equals(seq) || "false".equals(seq);
    }

    public static boolean isCharacter(CharSequence seq) {
        return seq.length() == 1;
    }

    public static boolean isPrimitiveString(CharSequence seq) {
        return notNull(seq) && (isNumber(seq) || isBoolean(seq) || isCharacter(seq));
    }

    // TODO: 17-5-13 colleciotion common validation
    public static boolean isEmpty(Collection<?> collection) {
        return isNull(collection) || collection.size() < 0;
    }

    public static boolean notEmpty(Collection<?> collection) {
        return !isEmpty(collection);
    }

    public static boolean contain(Collection<?> collection, Object elem) {
        return notEmpty(collection) && collection.contains(elem);
    }

    public static boolean noNullElement(Collection<?> collection) {
        if(isEmpty(collection)) return true;
        for(Object item : collection) {
            if(isNull(item)) {
                return false;
            }
        }
        return true;
    }

    public static boolean isEmpty(Map<?, ?> map) {
        return isNull(map) || map.size() < 0;
    }

    public static boolean notEmpty(Map<?, ?> map) {
        return !isEmpty(map);
    }


    public static boolean isInstance(Class<?> clazz, Object instance) {
        return notNull(clazz) && clazz.isInstance(instance);
    }

    public static boolean isInstance(Class<?> clazz, Object arg0, Object arg1) {
        return isInstance(clazz, arg0) && isInstance(clazz, arg1);
    }

    public static boolean isInstance(Class<?> clazz, Object arg0, Object... args) {
        boolean res = isInstance(clazz, arg0);
        for(Object item : args) {
            if(!res) return false;
            res &= isInstance(clazz, item);
        }
        return res;
    }


    public static boolean isInstance(Object instance, Class<?> clazz) {
        return isInstance(clazz, instance);
    }

    public static boolean isInstance(Object instance, Class<?> arg0, Class<?> arg1) {
        return isInstance(arg0, instance) && isInstance(arg1, instance);
    }

    public static boolean isInstance(Object instance, Class<?> arg0, Class<?>... args) {
        boolean res = isInstance(instance, arg0);
        for(Class<?> item : args) {
            if(!res) return false;
            res &= isInstance(instance, item);
        }
        return res;
    }

    public static boolean notInstance(Object instance, Class<?> clazz) {
        return !isInstance(instance, clazz);
    }

    public static boolean isAssignableFrom(Class<?> sup, Class<?> sub) {
        return notNull(sup) && sup.isAssignableFrom(sub);
    }

}
