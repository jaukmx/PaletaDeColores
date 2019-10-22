package mx.tecnm.itsfcp.paletadecolores;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.text.Layout;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.GridView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import yuku.ambilwarna.AmbilWarnaDialog;

public class MainActivity extends AppCompatActivity {
    GridView gvCuadriculaDeColores;
    Button BtnPerzonalizar;
    Layout lyFondo;
    List<String> nombreDeColores;
    int mDefaultColor;
    String hexadecimal;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        gvCuadriculaDeColores = findViewById(R.id.gvColores);
        BtnPerzonalizar = findViewById(R.id.lyPerzonalizar);


        nombreDeColores = new ArrayList<String>();
        ///Rojo
        nombreDeColores.add("ff0800");
        nombreDeColores.add("f80800");
        nombreDeColores.add("f00800");
        nombreDeColores.add("800800");
        ///Verde
        nombreDeColores.add("00ff00");
        nombreDeColores.add("00f800");
        nombreDeColores.add("00f000");
        nombreDeColores.add("008000");
        ///Azul
        nombreDeColores.add("0080ff");
        nombreDeColores.add("0080f8");
        nombreDeColores.add("0080f0");
        nombreDeColores.add("008080");

        nombreDeColores.add("f080ff");
        nombreDeColores.add("f080f8");
        nombreDeColores.add("f080f0");
        nombreDeColores.add("f08080");


        Adaptador adaptador = new Adaptador(MainActivity.this, R.layout.item_grid, nombreDeColores);
        gvCuadriculaDeColores.setAdapter(adaptador);


        gvCuadriculaDeColores.setOnItemClickListener(new AdapterView.OnItemClickListener() {


            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                System.out.println("El color es: #" + nombreDeColores.get(position));

                BtnPerzonalizar.setBackgroundColor(Color.parseColor("#"+nombreDeColores.get(position)));
                Toast.makeText(MainActivity.this, "El color es: #" + nombreDeColores.get(position),Toast.LENGTH_LONG).show();

            }


        });

        BtnPerzonalizar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                openColorPicker();

            }
        });

    }
        public void openColorPicker(){
            AmbilWarnaDialog colorPicker = new AmbilWarnaDialog(this, mDefaultColor, new AmbilWarnaDialog.OnAmbilWarnaListener() {
                @Override
                public void onCancel(AmbilWarnaDialog dialog) {

                }
//S
                @Override
                public void onOk(AmbilWarnaDialog dialog, int color) {
                    mDefaultColor=color;
                    hexadecimal =Integer.toHexString(color);
                    BtnPerzonalizar.setText(hexadecimal);
                    Toast.makeText(MainActivity.this, "El color es: #" + hexadecimal,Toast.LENGTH_LONG).show();


                    BtnPerzonalizar.setBackgroundColor(Color.parseColor("#"+hexadecimal));


                }

            });
            colorPicker.show();

        }

}
