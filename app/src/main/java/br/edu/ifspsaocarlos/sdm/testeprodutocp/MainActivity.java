package br.edu.ifspsaocarlos.sdm.testeprodutocp;

import android.content.ContentValues;
import android.database.Cursor;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    public static final String AUTHORITY = "br.edu.ifspsaocarlos.produtocp.provider";
    public static final Uri CONTENT_URI = Uri.parse("content://" + AUTHORITY + "/produtos");
    public static final String KEY_DESC = "descricao";
    public static final String KEY_PRECO = "preco";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ContentValues values = new ContentValues();
        values.put(KEY_DESC, "SmartWatch");
        values.put(KEY_PRECO, "1.300,00");
        Uri ins=getContentResolver().insert(CONTENT_URI, values);
        Cursor cursor=getContentResolver().query(CONTENT_URI, null, null, null, null);
        while (cursor.moveToNext()) {
            Log.d("Descricao:", cursor.getString(1));
            Log.d("Preco:", cursor.getString(2));
        }

    }
}
