package br.com.savioviana.agenda;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import br.com.savioviana.agenda.DAO.ContactDAO;
import br.com.savioviana.agenda.model.Contact;

public class MainActivity extends AppCompatActivity {

    private ListView list_contact;
    private Button btn_new_contact;

    public ListView getList_contact() {
        return list_contact;
    }

    public void setList_contact(ListView list_contact) {
        this.list_contact = list_contact;
    }

    public Button getBtn_new_contact() {
        return btn_new_contact;
    }

    public void setBtn_new_contact(Button btn_new_contact) {
        this.btn_new_contact = btn_new_contact;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        setList_contact((ListView) findViewById(R.id.list_contact));

        setBtn_new_contact((Button) findViewById(R.id.btn_new_contact));

        readContacts();

        getBtn_new_contact().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent= new Intent(getApplicationContext(), formularioContatoActivity.class);

                startActivity(intent);

            }
        });

    }

    @Override
    protected void onResume() {
        super.onResume();
        readContacts();
    }

    public void readContacts(){

        ContactDAO contactDAO = new ContactDAO(this);

        List<Contact> contacts = contactDAO.getAll();

        ArrayAdapter<Contact> adapterContacts = new ArrayAdapter<Contact>(getApplicationContext(), android.R.layout.simple_expandable_list_item_1, contacts);

        getList_contact().setAdapter(adapterContacts);

        contactDAO.close();
    }

}
