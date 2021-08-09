package com.example.myapplication.ui.search;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.widget.SearchView;
import androidx.fragment.app.Fragment;

import com.example.myapplication.R;

import java.util.ArrayList;
import java.util.List;

public class SearchFragment extends Fragment {
    private List<String> list;
    private ArrayList<String> arrayList;
    private BaseAdapter adapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_search, container, false);

        SearchView searchView = view.findViewById(R.id.search_view);
        ListView listView = view.findViewById(R.id.list_item);

        list = new ArrayList<>();
        settingList();

        arrayList = new ArrayList<>();
        arrayList.addAll(list);

        adapter = new SearchAdapter(getActivity(), list);
        listView.setAdapter(adapter);

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                search(newText);
                return true;
            }
        });

        return view;
    }

    private void search(String query) {
        list.clear();
        for (int i = 0; i < arrayList.size(); i++)
            if (arrayList.get(i).toLowerCase().contains(query.toLowerCase()))
                list.add(arrayList.get(i));
        adapter.notifyDataSetChanged();
    }

    private void settingList() {
        list.add("당근");
        list.add("상추");
        list.add("고사리");
        list.add("오이");
        list.add("양파");
        list.add("감자");
        list.add("고등어");
        list.add("광어");
        list.add("소고기");
        list.add("갈치");
        list.add("돼지고기");
        list.add("민어");
        list.add("연어");
        list.add("청양고추");
        list.add("오이고추");
    }
}