package com.alfimenkov.lab9;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import org.xmlpull.v1.XmlPullParser;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ListView listView;
    private TextView textView;
    private  ArrayList<Project> projects;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        XmlPullParser pullParser = getResources().getXml(R.xml.data);
        XmlParser parser = new XmlParser();
        parser.parse(pullParser);
        projects = parser.getProjects();


        textView = (TextView) findViewById(R.id.textView);

        StringBuilder sensorText = new StringBuilder();
        for (Project project : projects) {
            sensorText.append(project.getName()).append(System.getProperty("line.separator")).append(project.getDescription()).append(System.getProperty("line.separator")).append("\n");
        }
        TextView sensor_list = findViewById(R.id.textView);
        sensor_list.setText(sensorText);


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu,menu); //запуск меню
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId())
        {
            case R.id.aboutMenuItem:
                goToAuthor();
                break;
            case R.id.sendMsgItem:
                goToMsg();
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    public void goToAuthor() {
        Intent intent = new Intent(this, AboutMe.class);

        startActivity(intent);
    }

    public void goToMsg() {

        Intent intent = new Intent(this, SendMessage.class);

        startActivity(intent);
    }

    @Override
    protected void onStart() {
        super.onStart();

    }
}