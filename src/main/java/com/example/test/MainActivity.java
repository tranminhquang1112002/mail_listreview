package com.example.test;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import io.bloco.faker.Faker;
import io.bloco.faker.components.Time;

public class MainActivity extends AppCompatActivity {

    List<Mail> mails;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Faker faker = new Faker();
        mails = new ArrayList<>();


        for(int i = 0; i < 10000; ++i){
            String aSender = faker.name.name();
            String aTitle = faker.lorem.question(10);
            String aContent = faker.lorem.paragraph();
            mails.add(new Mail(aSender,aTitle,aContent, false, "11:11"));
        }

        MailAdapter adapter = new MailAdapter(mails);

        ListView listView = findViewById(R.id.list_view);
        listView.setAdapter(adapter);
    }
}