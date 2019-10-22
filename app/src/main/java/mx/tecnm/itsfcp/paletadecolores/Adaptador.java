package mx.tecnm.itsfcp.paletadecolores;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import static java.lang.Integer.toHexString;

public class Adaptador extends BaseAdapter {

    private Context context;
    private int layout;
    private List<String> ColorList;


    public Adaptador(Context context, int layout, List<String> colors) {
        this.context = context;
        this.layout = layout;
        this.ColorList = colors;
    }


    @Override
    public int getCount() {
        return this.ColorList.size();
    }

    @Override
    public Object getItem(int position) {
        return this.ColorList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View vista;

        LayoutInflater layoutInflater = LayoutInflater.from(this.context);
        vista =layoutInflater.inflate(this.layout,null);

        String nomColor =this.ColorList.get(position);



        //int colorDec = Integer.parseInt(nomColor);
//        System.out.println("Es es el color: "+nomColor);

               int Rojo,Verde,Azul;
        TextView lyColorN=  vista.findViewById(R.id.lycolorN);
        lyColorN.setText(nomColor);

        lyColorN.setBackgroundColor(Color.parseColor("#"+nomColor)) ;
         System.out.println("Es es el color: "+Color.rgb(120,0,120));
         int HEX=0,dec=Color.rgb(255,0,255);
        String hexadecimal =Integer.toHexString(-65536);

         System.out.println("El color.rgb es: "+dec+". De HExa a DEc: ffff0000 "+". En exa es: #"+hexadecimal+". Ejemplo: "+0xffff0000);






        return vista;
    }
}
