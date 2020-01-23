package com.software2_grupo3.ingenieriasoftware2proyecto.Modelos;

import android.app.Activity;
import android.app.Notification;
import android.content.Context;
import android.graphics.BitmapFactory;
import android.media.RingtoneManager;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Toast;

import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

import com.software2_grupo3.ingenieriasoftware2proyecto.ModuloAdministracion.Parametros;
import com.software2_grupo3.ingenieriasoftware2proyecto.R;

public class Utilidad {


    public void mostrarNotificacionSimple(Context context, String titulo, String texto, final int NOTIFICATION_ID){
        //Notification Channel ID passed as a parameter here will be ignored for all the Android versions below 8.0
        NotificationCompat.Builder builder = new NotificationCompat.Builder(context, Parametros.CHANNEL1_ID);
        builder.setContentTitle(titulo);
        builder.setContentText(texto);
        builder.setSmallIcon(R.drawable.ic_notifications_active_black_24dp);
        builder.setLargeIcon(BitmapFactory.decodeResource(context.getResources(), R.drawable.ic_notifications_active_black_24dp));
        builder.setAutoCancel(true);
        builder.setSound(RingtoneManager.getDefaultUri(RingtoneManager.TYPE_ALARM));
        builder.setVibrate(new long[] {
                500,
                500,
                500,
                500
        });

        builder.setVisibility(NotificationCompat.VISIBILITY_PUBLIC);
        builder.setPriority(NotificationCompat.PRIORITY_MAX);

        Notification notification = builder.build();
        NotificationManagerCompat notificationManagerCompat = NotificationManagerCompat.from(context);
        notificationManagerCompat.notify(NOTIFICATION_ID, notification);
    }

    public static void mostrarToast(Context context, String mensaje, int longitud){
        Toast.makeText(context, mensaje, longitud).show();
    }

    public static void ocultarTeclado(Activity activity) {
        View view = activity.getCurrentFocus();
        if (view != null) {
            InputMethodManager imm = (InputMethodManager) activity.getSystemService(Context.INPUT_METHOD_SERVICE);
            if(imm!=null){
                imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
            }
        }
    }

}
