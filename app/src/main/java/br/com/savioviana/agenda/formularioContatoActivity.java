package br.com.savioviana.agenda;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RatingBar;
import android.widget.Toast;

import br.com.savioviana.agenda.DAO.ContactDAO;
import br.com.savioviana.agenda.model.Contact;

public class formularioContatoActivity extends AppCompatActivity {

    private EditText text_name;
    private EditText text_address;
    private EditText text_phone;
    private EditText text_site;

    private RatingBar rating_avaible;

    private Button btn_save_contact;



    public EditText getText_name() {

        return text_name;
    }

    public void setText_name(EditText text_name) {
        this.text_name = text_name;
    }

    public EditText getText_address() {
        return text_address;
    }

    public void setText_address(EditText text_address) {
        this.text_address = text_address;
    }

    public EditText getText_phone() {
        return text_phone;
    }

    public void setText_phone(EditText text_phone) {
        this.text_phone = text_phone;
    }

    public EditText getText_site() {
        return text_site;
    }

    public void setText_site(EditText text_site) {
        this.text_site = text_site;
    }

    public RatingBar getRating_avaible() {
        return rating_avaible;
    }

    public void setRating_avaible(RatingBar rating_avaible) {
        this.rating_avaible = rating_avaible;
    }

    public Button getBtn_save_contact() {
        return btn_save_contact;
    }

    public void setBtn_save_contact(Button btn_save_contact) {
        this.btn_save_contact = btn_save_contact;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_formulario_contato);

        setText_name((EditText) findViewById(R.id.text_name));
        setText_address((EditText) findViewById(R.id.text_address));
        setText_phone((EditText) findViewById(R.id.text_phone));
        setText_site((EditText) findViewById(R.id.text_site));

        setRating_avaible((RatingBar) findViewById(R.id.rating_avalible));
        setBtn_save_contact((Button) findViewById(R.id.btn_save_contact));

        getBtn_save_contact().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Contact contact = new Contact();
                contact.setName(String.valueOf(getText_name().getText()));
                contact.setAddress(String.valueOf(getText_address().getText()));
                contact.setSite(String.valueOf(getText_site().getText()));
                contact.setPhone(String.valueOf(getText_phone().getText()));
                contact.setAvaible(getRating_avaible().getRating());

                ContactDAO contactDAO = new ContactDAO(getApplicationContext());
                contactDAO.create(contact);
                contactDAO.close();

                Toast.makeText(getApplicationContext(), "Cadastrado com sucesso", Toast.LENGTH_SHORT).show();

                finish();

            }
        });

    }
}
