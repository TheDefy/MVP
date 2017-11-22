package defy.com.mvp.util;

import android.util.Log;
import android.util.LruCache;

import java.util.ArrayList;
import java.util.List;

import defy.com.mvp.listener.ToastStrListener;

/**
 * Created by chenglei on 2017/11/22.
 */

public class ListenerProvider {

    private static final int CACHE_SIZE = 10;

    private static LruCache<String, Object> mCache = new LruCache<>(CACHE_SIZE);

    private static List<Class> listeners = new ArrayList<>();

    static {
        listeners.add(ToastStrListener.class);
    }

    /**
     * 获取接口实现(缺点：一个接口只能对应一个实现)
     * IToastStr iToastStr = ListenerProvider.getListener(IToastStr.class);
     *
     * @param c   接口
     * @param <T> 实现
     * @return
     */
    public static <T> T getListenerProvider(Class<T> c) {
        Object listenerImp = null;
        try {
            listenerImp = mCache.get(c.getSimpleName());
            if (listenerImp != null)
                return (T) listenerImp;

            for (Class temp : listeners) {
                if (isExtendInterface(c, temp)) {
                    listenerImp = temp.newInstance();
                    mCache.put(c.getSimpleName(), listenerImp);
                    break;
                }
            }

            if (listenerImp == null) {
                Log.e("Listener", "没有对应的实现....");
                return null;
            }

        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }

        return (T) listenerImp;
    }

    /**
     * 是否继承了此接口
     *
     * @param inter
     * @param imp
     * @return
     */
    private static boolean isExtendInterface(Class inter, Class imp) {
        Class[] interfaces = imp.getInterfaces();
        for (Class temp : interfaces) {
            if (temp.getName().equals(inter.getName())) {
                return true;
            }
        }
        return false;
    }
}
