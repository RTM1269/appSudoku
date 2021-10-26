package com.rtm.appsudoku;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    private EditText etn ;
    private String[] lista_et_id,lista_et_contenido;
    private String[][][][] list = new String[3][3][3][3];
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        etn = findViewById(R.id.et0000);

        int i = 0;
        lista_et_id = new String[81];
        String code;
        for (int r = 0; r < 3 ; r++){
            for (int c = 0; c < 3; c++){
                for (int f = 0; f < 3; f++){
                    for (int p = 0; p < 3; p++){
                        code = "et" + String.valueOf(r) + String.valueOf(c) + String.valueOf(f) + String.valueOf(p);
                      //  Log.i("ID",code);
                        lista_et_id[i]=code;
                        list[r][c][f][p]=code;Log.i("lista"," "+ list[r][c][f][p]);
                        i++;
                    }
                }
            }
        }

        imprimirListaEditText();
       // comprobarFilas();
       // comprobarColumnas();
       // comprobarColumnasOK(8);
        comprobarFilasOK(4);
    }
    public void imprimirListaEditText(){
        for (int i=0; i<lista_et_id.length;i++){
            Log.d("idS",lista_et_id[i]);
        }
    }
    public void volcarContenidoOK(){ //Recoge todos los valores de los EditText
        lista_et_contenido = new String[81];
        for (int r = 0; r < 3 ; r++){
            for (int c = 0; c < 3; c++){
                for (int f = 0; f < 3; f++){
                    for (int p = 0; p < 3; p++){
                        int etID = getResources().getIdentifier(list[r][c][f][p], "id", getPackageName());
                        etn = (EditText) findViewById(etID);
                        list[r][c][f][p] = etn.getText().toString();Log.i("cont",""+list[r][c][f][p]);
                    }
                }
            }
        }

    }
    public void volcarContenido(){ //Recoge todos los valores de los EditText
        lista_et_contenido = new String[81];
        for (int i = 0; i<lista_et_contenido.length;i++) {
            int etID = getResources().getIdentifier(lista_et_id[i], "id", getPackageName());
            etn = (EditText) findViewById(etID);
            lista_et_contenido[i] = etn.getText().toString();Log.i("cont",""+lista_et_contenido[i]);
        }
    }
    public void comprobarFilasOK(int punto){
        String[] nums ={"","","","","","","","",""};//9 huecosn por 9 posibles numeros
        volcarContenidoOK();
        int j=0,r=0,c=0,f=punto,p=0/*punto*/;
        //row 2
        if (punto==3){//4 - fila
            r=1;
            f=0;
        }else if(punto==4){//5 - fila
            r=1;
            f=1;
        }else if (punto==5){//6 - fila
            r=1;
            f=2;
        }
        //row 3
        if (punto==7){//7 - fila
            r=2;
            f=0;
        }else if(punto==8){//8 - fila
            r=2;
            f=1;
        }else if (punto==9){//9 - fila
            r=2;
            f=2;
        }

        while(c<3){
            nums[j]=list[r][c][f][p];
            Log.i("c "," "+nums[j]);
            j++;
            p++;

            if (p==3){
                p=0;
                c++;
            }

        }
        boolean repetido = false;
        for (int w=0; w<nums.length;w++){
            for (int q=0; q<nums.length;q++){
                if (nums[w].equals(nums[q]) && w!=q) {
                    repetido=true;
                    break;
                }
            }
            Log.i("numerous:","" + nums[w]);

        }
        String rep;
        if (repetido){
            rep="repetido";
        }else{
            rep="NO repetido";
        }
        Log.i("FILA COMPROBADA:","" + rep);
    }
    public void comprobarColumnasOK(int punto){
        String[] nums ={"","","","","","","","",""};//9 huecosn por 9 posibles numeros
        volcarContenidoOK();
        int j=0,r=0,c=0,f=0,p=punto/*punto*/;
        //cuadrado 2
        if (punto==3){//4 - columna
            c=1;
            f=
            p=0;
        }else if(punto==4){//5 - columna
            c=1;
            p=1;
        }else if (punto==5){//6 - columna
            c=1;
            p=1;
        }
        //cuadrado 3
        if (punto==7){//7 - columna
            c=2;
            p=0;
        }else if(punto==8){//8 - columna
            c=2;
            p=1;
        }else if (punto==9){//9 - columna
            c=2;
            p=2;
        }

        while(r<3){
                nums[j]=list[r][c][f][p];
                Log.i("c "," "+nums[j]);
                j++;
                f++;
            if (p==3){
                p=0;
            }
            if (f==3){
                f=0;
                r++;
            }

        }
        boolean repetido = false;
        for (int w=0; w<nums.length;w++){
            for (int q=0; q<nums.length;q++){
                if (nums[w].equals(nums[q]) && w!=q) {
                    repetido=true;
                    break;
                }
            }
            Log.i("numerous:","" + nums[w]);

        }
        String rep;
        if (repetido==true){
            rep="repetido";
        }else{
            rep="NO repetido";
        }
        Log.i("FILA COMPROBADA:","" + rep);
    }
    public void comprobarFilas(){ //Volcamos la fila que queremos comprobar en el array NUMS y posteriormente verificamos que no exista ninguna coincidencia
        String[] nums ={"","","","","","","","",""};//9 huecosn por 9 posibles numeros
        volcarContenido();
        int j=0,k=0,cont=0;
        while(j<9){
            if (cont<3){
                nums[j]=lista_et_contenido[k];
                j++;
                k++;
                cont++;
            }else {
                k=k+6;
                cont=0;
            }

        }
        boolean repetido = false;
        for (int w=0; w<nums.length;w++){
            for (int q=0; q<nums.length;q++){
                if (nums[w].equals(nums[q]) && w!=q) {
                    repetido=true;
                    break;
                }
            }
            Log.i("numerous:","" + nums[w]);

        }
        String rep;
        if (repetido==true){
            rep="repetido";
        }else{
            rep="NO repetido";
        }
        Log.i("FILA COMPROBADA:","" + rep);
    }
    public void comprobarColumnas(){
        String[] nums ={"","","","","","","","",""};//9 huecos por 9 posibles numeros
        volcarContenido();
        int j=0,cont=0,i=0;
        while(i<9){
            if(cont < 3){
                nums[i]=lista_et_contenido[j];
               // Log.i("c",""+nums[i]);
                Log.i("li"," "+ lista_et_contenido[j]);
                i++;
                j=j+3;
                cont++;
            }else{
                j=j+18;
                cont=0;
            }
        }
    }
}



