package com.example.listadetareas;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    // Declarar variables
    private EditText editTextTarea;
    private Button buttonAgregar;
    private ListView listViewTareas;
    private ArrayList<String> tareas;
    private ArrayAdapter<String> adaptador;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Referenciar elementos del layout
        editTextTarea = findViewById(R.id.editTextTask);
        buttonAgregar = findViewById(R.id.buttonAddTask);
        listViewTareas = findViewById(R.id.listViewTasks);

        // Inicializar ArrayList y ArrayAdapter
        tareas = new ArrayList<>();
        adaptador = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, tareas);
        listViewTareas.setAdapter(adaptador);

        // Agregar tarea al ArrayList y actualizar la lista
        buttonAgregar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String tarea = editTextTarea.getText().toString().trim();
                if (!tarea.isEmpty()) {
                    tareas.add(tarea);
                    adaptador.notifyDataSetChanged();
                    editTextTarea.setText("");
                }
            }
        });

        // Marcar tarea como completada y actualizar la lista
        listViewTareas.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                tareas.remove(position);
                adaptador.notifyDataSetChanged();
            }
        });
    }
}