package com.example.usuario.inventorydb.utils;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;

import com.example.usuario.inventorydb.R;
import com.example.usuario.inventorydb.pojo.Dependency;
import com.example.usuario.inventorydb.ui.Dependency.Presenter.ListDepencencyPresenter;
import com.example.usuario.inventorydb.ui.base.BasePresenter;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by usuario on 13/11/17.
 */

public final class CommonUtils {

    /**
     * Método que comprueba los sigientes requisitos
     * contiene al menos un digito 0-9
     * contiene al menos un carácter Mayuscula
     * contiene al menos un carácter Minuscula
     * contiene al menos 6 carácteres
     *
     * @param password
     * @return
     */
    public static boolean isPasswordvalid(String password) {
        final String PASSWORD_PATTERN = "^(?=.*[0-9])(?=.*[A-Z])(?=.*[a-z]).{6,}$";
        Pattern pattern;
        Matcher matcher;

        pattern = Pattern.compile(PASSWORD_PATTERN);
        matcher = pattern.matcher(password);

        return matcher.matches();
    }

    public static ProgressDialog ShowLoadinfDialog(Context context){
        ProgressDialog progressDialog = new ProgressDialog(context);
        progressDialog.show();

        if (progressDialog.getWindow() != null){
            progressDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        }
        //progressDialog.setContentView(R.layout.progress_layout);
        progressDialog.setIndeterminate(true);
        progressDialog.setCancelable(false);
        progressDialog.setCanceledOnTouchOutside(false);
        return progressDialog;
    }


    public static Dialog ShowConfirmDialog(final Bundle bundle, Context context, final BasePresenter presenter) {
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setMessage(bundle.getString(ConfirmationDialog.MESSAGE))
                .setTitle(bundle.getString(ConfirmationDialog.TITULO))
                .setPositiveButton(R.string.btnOK, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        if(presenter instanceof ListDepencencyPresenter)
                            ((ListDepencencyPresenter)presenter).EliminarDependency((Dependency) bundle.getParcelable(ConfirmationDialog.DEPENDENCY));
                        dialog.cancel();
                    }
                })
                .setNegativeButton(R.string.btnCancel, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                    }
                });
        return builder.create();
    }

}
