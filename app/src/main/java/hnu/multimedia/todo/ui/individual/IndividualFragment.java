package hnu.multimedia.todo.ui.individual;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;

import hnu.multimedia.todo.R;
import hnu.multimedia.todo.SettingActivity;
import hnu.multimedia.todo.databinding.FragmentIndividualBinding;

public class IndividualFragment extends Fragment {

    private FragmentIndividualBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        IndividualViewModel individualViewModel =
                new ViewModelProvider(this).get(IndividualViewModel.class);

        binding = FragmentIndividualBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        TaskIndividualAdapter adapter = new TaskIndividualAdapter();
        binding.listTodoIndividual.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false));
        binding.listTodoIndividual.setAdapter(adapter);


        individualViewModel.getTaskList().observe(getViewLifecycleOwner(), taskIndividualItems -> {
            adapter.setTaskItemList(taskIndividualItems);
        });

        setHasOptionsMenu(true);

        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        super.onCreateOptionsMenu(menu,inflater);
        inflater.inflate(R.menu.setting_menu, menu);
    }
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.menu_setting:
                Intent intent = new Intent(getActivity(), SettingActivity.class);
                startActivity(intent);
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}