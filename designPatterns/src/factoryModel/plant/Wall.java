package factoryModel.plant;

import factoryModel.component.Shell;

public class Wall implements Plant {
    private Shell shell;

    public Wall() {
        Shell shell = new Shell();
        shell.setHardness(5);
        this.shell = shell;
    }

    @Override
    public String getName() {
        return "��ǽ";
    }

    @Override
    public void fight() {
        System.out.println("���ȵ�վ�ڲݵ���");
    }

    public Shell getShell() {
        return shell;
    }

    public void setShell(Shell shell) {
        this.shell = shell;
    }
}
