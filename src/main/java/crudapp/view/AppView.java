package crudapp.view;

public class AppView {
    SkillView skillView = new SkillView();
    SpecialtyView specialtyView = new SpecialtyView();
    DeveloperView developerView = new DeveloperView();
    public void mainWorkProgram(){
        skillView.workProgram();
        specialtyView.workProgram();
        developerView.workProgram();
    }

    public static AppView appView;

    private AppView(){}

    public static AppView getAppView(){
        if (appView == null){
            appView = new AppView();
        }
        return appView;
    }
}
