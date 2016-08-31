package me.yamlee.demo.recyclerview;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import me.yamlee.demo.BaseActivity;
import me.yamlee.demo.R;

/**
 * Created by yamlee on 16/3/15.
 */
public class RecyclerViewActivity extends BaseActivity {
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_view_demo);
        recyclerView = (RecyclerView) findViewById(R.id.rv_demo);
        MyAdapter adapter = new MyAdapter();
        List<InfoModel> infoModels = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            InfoModel infoModel = new InfoModel();
            infoModel.drawableId = R.drawable.icon;
            infoModel.title = "标题" + i;
            infoModels.add(infoModel);
        }
        adapter.setData(infoModels);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }

    class MyViewHolder extends RecyclerView.ViewHolder {
        private ImageView imageView;
        private TextView textView;

        public MyViewHolder(View itemView) {
            super(itemView);
            imageView = (ImageView) itemView.findViewById(R.id.iv_logo);
            textView = (TextView) itemView.findViewById(R.id.tv_title);
        }
    }


    class MyAdapter extends RecyclerView.Adapter<MyViewHolder> {
        private List<InfoModel> infoModelList = new ArrayList<>(0);

        public void setData(List<InfoModel> infoModels) {
            this.infoModelList = infoModels;
        }

        @Override
        public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_recycler_view, null);
            return new MyViewHolder(view);
        }

        @Override
        public void onBindViewHolder(MyViewHolder holder, int position) {
            holder.textView.setText(infoModelList.get(position).title);
            holder.imageView.setImageResource(infoModelList.get(position).drawableId);
        }

        @Override
        public int getItemCount() {
            return infoModelList.size();
        }

        @Override
        public int getItemViewType(int position) {
            return super.getItemViewType(position);
        }
    }

    class InfoModel {
        public int drawableId;
        public String title;
    }
}

