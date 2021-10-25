package com.rtm.appsudoku;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    private EditText etn ;
    private String[] lista_et_id,lista_et_contenido;
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
                        int etID = getResources().getIdentifier(code,"id",getPackageName());
                        etn = findViewById(etID);
                        Log.i("ID",code);
                        lista_et_id[i]=code;
                        i++;
                    }
                }
            }
        }
        imprimirListaEditText();
       // comprobarFilas();
        comprobarColumnas();
    }
    public void imprimirListaEditText(){
        for (int i=0; i<lista_et_id.length;i++){
            Log.d("idS",lista_et_id[i]);
        }
    }
    public void volcalContenido(){ //Recoge todos los valores de los EditText
        lista_et_contenido = new String[81];
        for (int i = 0; i<lista_et_contenido.length;i++) {
            int etID = getResources().getIdentifier(lista_et_id[i], "id", getPackageName());
            etn = (EditText) findViewById(etID);
            lista_et_contenido[i] = etn.getText().toString();//Log.i("cont",""+lista_et_contenido[i]);
        }
    }
    public void comprobarFilas(){ //Volcamos la fila que queremos comprobar en el array NUMS y posteriormente verificamos que no exista ninguna coincidencia
        String[] nums ={"","","","","","","","",""};//9 huecosn por 9 posibles numeros
        volcalContenido();
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
        String[] nums ={"","","","","","","","",""};//9 huecosn por 9 posibles numeros
        volcalContenido();
        int j=0,cont=0;
        for (int i=0; i<9;i++){
            if(cont < 3){
                nums[i]=lista_et_contenido[j];
                j=j+3;
                Log.i("c",""+nums[i]);
            }else{
                j=j+20;
                cont=0;
            }
        }
    }
}



