package nyc.c4q.unit04mid_unitassessment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


/**
 * A simple {@link Fragment} subclass.
 */
public class MainFragment extends Fragment {

    View rootView;
    Button buttonMainFragment;


    public MainFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        rootView = inflater.inflate(R.layout.fragment_main, container, false);

        buttonMainFragment = rootView.findViewById(R.id.button_mainfragment);

        buttonMainFragment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                DisplayFragment displayFragment = new DisplayFragment();
                FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();


                fragmentTransaction.replace(R.id.fragment_container, displayFragment).addToBackStack("Murad").commit();
            }
        });

        return rootView;

    }

}
