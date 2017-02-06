package test.littleswords.com.annotationtest.simplebutterknife;

import android.app.Activity;
import android.view.View;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Created by wenchaokong on 6/02/2017.
 */

public class ButterKnife {
    private static void initViews(Object object, View sourceView){
        Field[] fields = object.getClass().getFields();
        for(Field field : fields){
            if(field.isAnnotationPresent(ViewInject.class)){
                ViewInject viewInject = field.getAnnotation(ViewInject.class);
                int viewId = viewInject.id();
                boolean clickable = viewInject.clickable();
                if(viewId != -1){
                    try {
                        field.setAccessible(true);
                        field.set(object, sourceView.findViewById(viewId));
                        if(clickable){
                            sourceView.findViewById(viewId).setOnClickListener((View.OnClickListener) (object));
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

    private static void initContent(Object object){
        Class activity  = object.getClass();
        ContentView contentView = (ContentView) activity.getAnnotation(ContentView.class);
        int id = contentView.value();
        try {
            Method method = object.getClass().getMethod("setContentView", int.class);
            method.invoke(activity, id);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }

    }

    public void init(Activity activity){
        initContent(activity);
        initViews(activity, activity.getWindow().getDecorView());
    }
}
