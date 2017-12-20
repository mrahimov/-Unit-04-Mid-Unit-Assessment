package nyc.c4q.unit04mid_unitassessment;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import model.DataModel;
import model.JsonDataHolder;


/**
 * A simple {@link Fragment} subclass.
 */
public class BottomFragmen extends Fragment {

    private View rootView;
    private List<DataModel> data;

    public BottomFragmen() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        rootView = inflater.inflate(R.layout.fragment_bottom, container, false);

        return rootView;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        JsonDataHolder jsonDataHolder = new JsonDataHolder();
        data = new ArrayList<>();

        try {
            String jsonData = jsonDataHolder.jsonData;

            JSONObject jsonObject = new JSONObject(jsonData);
            JSONArray jsonArray = jsonObject.getJSONArray("books");

            for (int i = 0; i < jsonArray.length(); i++) {

                JSONObject jsonObject1 = jsonArray.getJSONObject(i);

                String title = jsonObject1.getString("title");
                String author = jsonObject1.getString("author");
                int year = jsonObject1.getInt("year");

                DataModel dataModel = new DataModel(title, author, year);

                dataModel.setTitle(title);
                dataModel.setAuthor(author);
                dataModel.setYear(year);
                data.add(dataModel);

            }


        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}
