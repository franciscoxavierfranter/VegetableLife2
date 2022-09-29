package com.example.vegetablelife2.ui.slideshow;

import android.content.Context;
import android.icu.util.ValueIterator;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.FrameLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.vegetablelife2.R;
import com.example.vegetablelife2.databinding.FragmentGalleryBinding;
import com.example.vegetablelife2.databinding.FragmentSlideshowBinding;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class SlideshowFragment extends Fragment {

    String[] foodies={"El Tomatito","Pan y Cereal","El Lechugas","ComboVegan","MateLimon","Miel de Palma","Brocolito","Consome de Apio"};
    private FragmentGalleryBinding binding;

    /*public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        SlideshowViewModel slideshowViewModel =
                new ViewModelProvider(this).get(SlideshowViewModel.class);

        binding = FragmentSlideshowBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        final TextView textView = binding.tituloSegundoid;
        slideshowViewModel.getText().observe(getViewLifecycleOwner(), textView::setText);
        return root;
    }*/ //original oncreateView

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View view = LayoutInflater.from(getContext()).inflate(R.layout.fragment_slideshow,container,false);
        RecyclerView recyclerView = view.findViewById(R.id.listRecycleeView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this.getContext()));
        recyclerView.setAdapter(new ListAdapter(foodies));

        /*FrameLayout layout = new FrameLayout(getContext());
        layout.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,ViewGroup.LayoutParams.MATCH_PARENT));
        layout.setId(R.id.listRecycleeView);
        setContentView(layout);

        getSupportFragmentManager().beginTransaction().add(R.id.listRecycleeView,new SlideshowFragment()).commit();*/

        return view;


    }



    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}