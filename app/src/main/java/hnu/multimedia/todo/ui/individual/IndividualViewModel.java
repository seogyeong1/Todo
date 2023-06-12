package hnu.multimedia.todo.ui.individual;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.ArrayList;

public class IndividualViewModel extends ViewModel {
    private final MutableLiveData<ArrayList<TaskIndividualItem>> taskList;

    public IndividualViewModel() {
        taskList = new MutableLiveData<>();
        ArrayList<TaskIndividualItem> _list = new ArrayList<>();

        for (int i = 0 ; i < 10 ; i ++) {
            _list.add(new TaskIndividualItem(String.valueOf(i)));
        }
        taskList.setValue(_list);
    }

    public LiveData<ArrayList<TaskIndividualItem>> getTaskList() {
        return taskList;
    }
}