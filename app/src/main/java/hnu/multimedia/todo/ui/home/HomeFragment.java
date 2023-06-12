package hnu.multimedia.todo.ui.home;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;

import hnu.multimedia.todo.databinding.FragmentHomeBinding;

public class HomeFragment extends Fragment {

    private FragmentHomeBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        HomeViewModel homeViewModel =
                new ViewModelProvider(this).get(HomeViewModel.class);

        binding = FragmentHomeBinding.inflate(inflater, container, false);
        View root = binding.getRoot();



        TaskAdapter adapter = new TaskAdapter();
        binding.listTodoIndividual.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false));
        binding.listTodoIndividual.setAdapter(adapter);
        binding.listTodoTeam.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false));
        binding.listTodoTeam.setAdapter(adapter);

        homeViewModel.getTaskList().observe(getViewLifecycleOwner(), taskItems -> {
            adapter.setTaskItemList(taskItems);
        });

        binding.btnAddTask.setOnClickListener(v-> {
            startActivity(new Intent(getContext(), UploadActivity.class));
        });



        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

}