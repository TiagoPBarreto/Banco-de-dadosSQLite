package com.cursoandroid.bancodedadossqlite;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        try {
            //criar banco de dados
            SQLiteDatabase bancoDados = openOrCreateDatabase("app", MODE_PRIVATE, null);


            //criar tabela / tabela com identificador
            bancoDados.execSQL("CREATE TABLE IF NOT EXISTS pessoas( id INTEGER PRIMARY KEY AUTOINCREMENT, nome VARCHAR, idade INT(3))");
            // excluir tabela
             //bancoDados.execSQL("DROP TABLE pessoas");

            //inserindo os dados
            //bancoDados.execSQL("INSERT INTO pessoas( nome, idade) VALUES ('Mariana', 18 )");
            //bancoDados.execSQL("INSERT INTO pessoas( nome, idade) VALUES ('Maria', 35 )");

            // UPDATE atualização
            //bancoDados.execSQL("UPDATE pessoas SET idade = 19, nome ='Mariana Silva' WHERE id = 3");

            //Deletar registro do banco de dados
            //bancoDados.execSQL("DELETE FROM pessoas WHERE id = 2");

            //deletar tudo
            bancoDados.execSQL("DELETE FROM pessoas ");



            //recuperar as pessoas
            /*String consulta = "SELECT nome, idade FROM pessoas " +
                              "WHERE nome = 'Tiago' AND idade = 29 ";
             */
            /*String consulta = "SELECT nome, idade FROM pessoas " +
                              "WHERE idade> 35 OR idade = 18";

             */
            /*String consulta = "SELECT nome, idade FROM pessoas " +
                               "WHERE nome IN ('Maria', 'Tiago') ";

             */
            /*String consulta = "SELECT nome, idade FROM pessoas " +
                              "WHERE idade BETWEEN 29 AND 50";

             */
            /*String filtro = "mar";
            String consulta = "SELECT nome, idade FROM pessoas " +
                    "WHERE nome LIKE '%"+filtro+"%' ";

             */
            /*String consulta = "SELECT nome, idade FROM pessoas " +
                              "WHERE 1=1 ORDER BY idade ASC  ";

             */
            /*String consulta = "SELECT nome, idade FROM pessoas " +
                    "WHERE 1=1 ORDER BY nome DESC  ";

             */
            /*String consulta = "SELECT nome, idade FROM pessoas " +
                    "WHERE 1=1 ORDER BY nome DESC LIMIT 3 ";

             */
            /*
            String consulta = "SELECT id, nome, idade FROM pessoas " +
                               "WHERE 1=1";

             */
            //o * traz todos os campos selecionados
            String consulta = "SELECT * FROM pessoas " +
                    "WHERE 1=1";


            Cursor cursor = bancoDados.rawQuery( consulta ,null);

            //indices da tabela
            int indiceId = cursor.getColumnIndex("id");
            int indiceNome = cursor.getColumnIndex("nome");
            int indiceIdade = cursor.getColumnIndex("idade");
            cursor.moveToFirst();
            while (cursor!=null){

                String nome = cursor.getString(indiceNome);
                String idade = cursor.getString(indiceIdade);
                String id = cursor.getString(indiceId);

                Log.i("RESULTADO-id ", id + " / nome: " + nome +  " / idade "  + idade);
                //Log.i("RESULTADO-idade", idade);
                cursor.moveToNext();
            }
        }catch (Exception e){
            e.printStackTrace();

        }

    }
}