package nyc.c4q.unit04mid_unitassessment;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class TopFragment extends Fragment {

    View rootView;
    TextView title;
    TextView author;
    TextView year;

    public TopFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        rootView = inflater.inflate(R.layout.fragment_top, container, false);

        title = rootView.findViewById(R.id.textview_title);
        author = rootView.findViewById(R.id.textview_author);
        year = rootView.findViewById(R.id.textview_year);


        return rootView;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        Bundle bundle = getArguments();
        if (bundle != null) {

            String titleBundle = bundle.getString("title", "empty");
            String authorBundle = bundle.getString("author", "empty");
            int yearBundle = bundle.getInt("year", 0);

            title.setText(titleBundle);
            author.setText(authorBundle);
            year.setText(String.valueOf(yearBundle));
        }
    }

}
