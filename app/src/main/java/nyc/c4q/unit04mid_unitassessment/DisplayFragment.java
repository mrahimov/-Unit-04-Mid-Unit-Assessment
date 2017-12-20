package nyc.c4q.unit04mid_unitassessment;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import model.DataModel;


/**
 * A simple {@link Fragment} subclass.
 */
public class DisplayFragment extends Fragment implements PassDataInterface{

    private View rootView;
    private BottomFragment bottomFragment;
    private TopFragment topFragment;


    public DisplayFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        rootView = inflater.inflate(R.layout.fragment_display, container, false);


        return rootView;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        topFragment = new TopFragment();
        FragmentManager manager = getChildFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.add(R.id.top_container, topFragment).addToBackStack("top");
        transaction.commit();


        bottomFragment = new BottomFragment();
        bottomFragment.setListener(this);
        FragmentTransaction bottomTransaction = manager.beginTransaction();
        bottomTransaction.add(R.id.bottom_container, bottomFragment).addToBackStack("bottom");
        bottomTransaction.commit();

    }
    public void passData (DataModel model) {
        topFragment = new TopFragment();
        FragmentManager manager = getChildFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();

        Bundle bundle = new Bundle();
        bundle.putString("title", model.getTitle());
        bundle.putString("author", model.getAuthor());
        bundle.putInt("year", model.getYear());

        topFragment.setArguments(bundle);
        transaction.replace(R.id.top_container, topFragment).addToBackStack("");
        transaction.commit();


    }
}
