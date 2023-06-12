package hnu.multimedia.todo.ui.team;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.ArrayList;

public class TeamViewModel extends ViewModel {

    private final MutableLiveData<ArrayList<TaskTeamItem>> taskList;

    public TeamViewModel() {
        taskList = new MutableLiveData<>();
        ArrayList<TaskTeamItem> _list = new ArrayList<>();

        for (int i = 0 ; i < 10 ; i ++) {
            _list.add(new TaskTeamItem(String.valueOf(i)));
        }
        taskList.setValue(_list);
    }

    public LiveData<ArrayList<TaskTeamItem>> getTaskList() {
        return taskList;
    }
}