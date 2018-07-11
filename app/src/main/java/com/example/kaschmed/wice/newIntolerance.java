package com.example.kaschmed.wice;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.TextView;

import com.example.kaschmed.wice.Lokal.Database;
import com.example.kaschmed.wice.Lokal.IntoleranceInterDAO;

import java.lang.ref.WeakReference;
import java.util.List;

import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;

public class newIntolerance extends AppCompatActivity {


    private Button add;
    private EditText intoleranceName;
    private EditText enumber;

    //Adapter
    List<IntolerancesforRooms> intoleranzenList;
    ArrayAdapter adapter;

    //Database
    private IntoleranceInterDAO intoleranceInterDAO;
    private Database database;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_intolerance);

        //hinzufügen des buttons u der view


        add = (Button)findViewById(R.id.add);
        intoleranceName = (EditText) findViewById(R.id.intoleranceName);
        enumber = (EditText)findViewById(R.id.enumber);


        //adapter for List
       /** adapter = new ArrayAdapter(this,android.R.layout.simple_list_item_1,intoleranzenList);
        registerForContextMenu(gridLayout);
        gridLayout.setAdapter(adapter);**/


        //Datenbank
        //create Database
        Database database = Database.getInstance(this);

        //loadData();!!!!!!!!

        //Event
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Add new Intolerance
                final Database database = io.reactivex.Observable.create(new ObservableOnSubscribe<Object>() {

                    @Override
                    public void subscribe(ObservableEmitter<Object> e) throws Exception {
                        IntolerancesforRooms intolerancesforRooms = new IntolerancesforRooms("Milchsäure",
                                "E270" );
                        intoleranceInterDAO.insertIntoTolerances();
                        e.onComplete();

                    }
                })





            }
        });




    }

    public void onGetAllIntoleranzesSucess(List<IntolerancesforRooms> intolerancesforRooms){

        intoleranzenList.clear();
        intoleranzenList.addAll(intolerancesforRooms);
        adapter.notifyDataSetChanged();
    }


    private class InsertTask extends AsyncTask<Void, Integer, Integer> {

        private WeakReference<newIntolerance> activityReference;
        private newIntolerance intolerance;


        // only retain a weak reference to the activity
        InsertTask(newIntolerance context, newIntolerance intolerance) {
            activityReference = new WeakReference<>(context);
            this.intolerance = intolerance;
        }

        protected void onPreExecute() {
            gridLayout.setVisibility(View.GONE);
            create.setVisibility(View.VISIBLE);
        }

        // doInBackground methods runs on a worker thread
        @Override
        protected Integer doInBackground(Void... objs) {
            try {
                if (activityReference.get().database.intoleranceInterDAO().checkUser(user.getMail()) == null) {
                    activityReference.get().database.intoleranceInterDAO().insertIntoTolerances();
                    return 1;
                } else {
                    return 2;
                }
            } catch (Exception e) {
                e.toString();
                e.getStackTrace();
                return 3;
            }
        }


    }

}
