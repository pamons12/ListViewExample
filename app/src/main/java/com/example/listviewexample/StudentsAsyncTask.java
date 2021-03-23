package com.example.listviewexample;

import android.content.Context;
import android.os.AsyncTask;
import android.widget.ListView;

import java.util.ArrayList;

public class StudentsAsyncTask extends AsyncTask<Void,Void, ArrayList<Student>> {

    private ListView listView;
    private Context context;

    public StudentsAsyncTask(ListView listView, Context context) {
        this.listView = listView;
        this.context = context;
    }

    @Override
    protected ArrayList<Student> doInBackground(Void... voids) {
        StudentDAO studentDAO = new StudentDAO();

        return studentDAO.getListOfStudents();
    }

    @Override
    protected void onPostExecute(ArrayList<Student> students) {
        super.onPostExecute(students);

        StudentAdapter adapter = new StudentAdapter(context, students);
        listView.setAdapter(adapter);

    }
}
