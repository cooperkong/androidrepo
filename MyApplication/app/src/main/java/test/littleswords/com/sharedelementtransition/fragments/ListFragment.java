package test.littleswords.com.sharedelementtransition.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewCompat;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.transition.Scene;
import android.transition.TransitionSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import test.littleswords.com.coordinatelayout.R;
import test.littleswords.com.coordinatelayout.transition.DetailsTransition;

/**
 * Created by wenchaokong on 25/02/2017.
 */

public class ListFragment extends Fragment {

    private RecyclerView recyclerView;
    private Scene mAScene;
    private TransitionSet transitionSet;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.list_fragment, container, false);

        recyclerView = (RecyclerView) v.findViewById(R.id.recyclerview);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setAdapter(new RecyclerView.Adapter() {
            @Override
            public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
                return new ItemViewHolder(LayoutInflater.from(getContext()).inflate(R.layout.item, parent, false));
            }

            @Override
            public void onBindViewHolder(final RecyclerView.ViewHolder holder, final int position) {
                final ItemViewHolder holder1 = (ItemViewHolder) holder;
                ViewCompat.setTransitionName(holder1.itemView, String.valueOf(position) + "_image");
                holder1.button.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        final ContentFragment contentFragment = new ContentFragment();

                        Bundle bundle = new Bundle();
                        bundle.putInt("name", position);
                        contentFragment.setArguments(bundle);
                        DetailsTransition detailsTransition = new DetailsTransition();
                        contentFragment.setSharedElementEnterTransition(detailsTransition);
                        contentFragment.setSharedElementReturnTransition(detailsTransition);
                        getActivity()
                                .getSupportFragmentManager()
                                .beginTransaction()
                                .addSharedElement(holder1.itemView, "wenchao")
                                .replace(R.id.container, contentFragment)
                                .addToBackStack(null)
                                .commit();
                    }
                });
            }


            @Override
            public int getItemCount() {
                return 30;
            }
        });
        return v;
    }


    static class ItemViewHolder extends RecyclerView.ViewHolder {
        ImageView imageview;
        Button button;

        ItemViewHolder(View itemView) {
            super(itemView);
            imageview = (ImageView) itemView.findViewById(R.id.image);
            button = (Button) itemView.findViewById(R.id.button);
        }
    }

}
