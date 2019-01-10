package br.com.savioviana.agenda.DAO;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

import br.com.savioviana.agenda.model.Contact;

public class ContactDAO extends SQLiteOpenHelper {


    public ContactDAO(Context context) {
        super(context, "agenda", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        String sql = "CREATE TABLE IF NOT EXISTS contact(" +
                        "contact_id INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, " +
                        "contact_name TEXT NOT NULL, " +
                        "contact_address TEXT NOT NULL, " +
                        "contact_phone TEXT NOT NULL, " +
                        "contact_site TEXT NOT NULL, " +
                        "contact_avaible DOUBLE NOT NULL);";

        db.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {

    }

    public void create(Contact contact){

        SQLiteDatabase conexao = getWritableDatabase();
        ContentValues data = new ContentValues();

        data.put("contact_name", contact.getName() );
        data.put("contact_address", contact.getAddress());
        data.put("contact_phone", contact.getPhone());
        data.put("contact_site", contact.getSite());
        data.put("contact_avaible", contact.getAvaible());

        conexao.insertOrThrow("contact", null, data);

    }

    public List<Contact> getAll(){

        SQLiteDatabase conexao = getReadableDatabase();
        Cursor cursor = conexao.query("contact", null,null,null,null,null,null);

        List<Contact> contacts_list = new ArrayList<Contact>();

        if(cursor.getCount() > 0){
            cursor.moveToFirst();

            do{
                Contact contact = new Contact();

                contact.setContact_id(cursor.getInt(cursor.getColumnIndex("contact_id")));
                contact.setName(cursor.getString(cursor.getColumnIndex("contact_name")));
                contact.setAddress(cursor.getString(cursor.getColumnIndex("contact_address")));
                contact.setPhone(cursor.getString(cursor.getColumnIndex("contact_phone")));
                contact.setSite(cursor.getString(cursor.getColumnIndex("contact_site")));
                contact.setAvaible(cursor.getFloat(cursor.getColumnIndex("contact_avaible")));

                contacts_list.add(contact);

            }while (cursor.moveToNext());
        }

        return contacts_list;
    }



}
