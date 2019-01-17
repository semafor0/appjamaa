package one.jamaa.appjamaa.main.contract;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;
import android.util.Log;

import java.util.HashMap;

import one.jamaa.appjamaa.information.Projects;

public class ProjectViewModel extends ViewModel {

    private static final String TAG = "ProjectViewModel";

    private MutableLiveData<Projects> project = new MutableLiveData<>();

    public void setProject(Projects input){
        project.setValue(input);
    }

    public MutableLiveData<Projects> getProject() {
        return project;
    }

}
