package controler;

import android.graphics.ColorSpace;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import model.DataModel;
import nyc.c4q.unit04mid_unitassessment.PassDataInterface;
import nyc.c4q.unit04mid_unitassessment.R;
import view.MyViewHolder;

/**
 * Created by muridjonrahimov on 12/19/17.
 */

public class MyAdapter extends RecyclerView.Adapter<MyViewHolder> {
    List<DataModel> dataModels = new ArrayList<>();
    private PassDataInterface passDataInterface;

    public MyAdapter(List<DataModel> dataModels, PassDataInterface passDataInterface) {
        this.dataModels = dataModels;
        this.passDataInterface = passDataInterface;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_view, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {

        DataModel dataModel = dataModels.get(position);
        holder.onBind(dataModel, passDataInterface);
    }

    @Override
    public int getItemCount() {
        return dataModels.size();
    }


}

