package kkmapp.application;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import kkmapp.application.util.BaseFragment;
import kkmapp.application.util.PropertiesIO;

public class TodoListFragment extends BaseFragment {

    private List<List<String>> list = new ArrayList<>();
    public TodoListFragment() {
        super();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.todolist, container, false);
    }

    @Override
    protected void guiSetUp() {

    }

    private void leadTodoList() {
        String url = "todo_list.properties";
        Properties prop = PropertiesIO.loadEProperties(url, getContext());

        int i = 0;
        while(true) {
            String text1 = prop.getProperty("LIST"+i, "NONE");
            if(text1.equals("NONE")) {
                break;
            }

            else {
                List<String> todoList = new ArrayList<>();
                todoList.add(text1);
                int j = 0;
                while(j == 0) {
                    String text2 = prop.getProperty("ITEM"+i+""+j, "NONE");
                    if(text2.equals("NONE")) break;
                    todoList.add(text2);
                    j++;
                }
                list.add(todoList);
                i++;
            }
        }
    }
}
