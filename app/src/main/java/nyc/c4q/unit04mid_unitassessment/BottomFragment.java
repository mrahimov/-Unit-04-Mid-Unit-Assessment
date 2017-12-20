package nyc.c4q.unit04mid_unitassessment;



import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import controler.MyAdapter;
import model.DataModel;
import model.JsonDataHolder;


/**
 * A simple {@link Fragment} subclass.
 */
public class BottomFragment extends Fragment {

    private View rootView;
    private List<DataModel> models;
    private PassDataInterface passDataInterface;
    private JsonDataHolder json;

    public BottomFragment() {
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
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);


    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        models = new ArrayList<>();
        try {
            json = new JsonDataHolder();
            String jsonData = json.jsonData;

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
                models.add(dataModel);

            }


        } catch (JSONException e) {
            e.printStackTrace();
        }

        RecyclerView recyclerView = rootView.findViewById(R.id.recycler_view);
        MyAdapter adapter = new MyAdapter(models, passDataInterface);

        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(layoutManager);



    }

    public void setListener(PassDataInterface passDataInterface) {
        this.passDataInterface = passDataInterface;
    }
}