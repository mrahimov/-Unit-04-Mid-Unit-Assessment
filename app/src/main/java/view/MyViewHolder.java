package view;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import model.DataModel;
import nyc.c4q.unit04mid_unitassessment.PassDataInterface;
import nyc.c4q.unit04mid_unitassessment.R;

/**
 * Created by muridjonrahimov on 12/19/17.
 */

public class MyViewHolder extends RecyclerView.ViewHolder{
    TextView textView;

    public MyViewHolder(View itemView) {
        super(itemView);

        textView = itemView.findViewById(R.id.book_title);


    }
    public void onBind(final DataModel model, final PassDataInterface passDataInterface) {
        textView.setText(model.getTitle());


        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                passDataInterface.passData(model);

            }
        });

    }
}
