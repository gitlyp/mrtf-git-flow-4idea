package com.github.xiaolyuh.action;

import com.github.xiaolyuh.utils.ConfigUtil;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.util.IconLoader;
import org.jetbrains.annotations.Nullable;

import javax.swing.*;

/**
 * 提测
 *
 * @author yuhao.wang3
 */
public class StartTestAction extends AbstractMergeAction {

    public StartTestAction() {
        super("提测", "将当前开发分支合并到test分支", IconLoader.getIcon("/icons/mergeToTest.svg"));
    }

    @Override
    protected String getTargetBranch(Project project) {
        return ConfigUtil.getConfig(project).get().getTestBranch();
    }

    @Override
    protected String getDialogTitle(Project project) {
        return "提测";
    }

    @Override
    protected String getTaskTitle(Project project) {
        return String.format("将 %s 分支，合并到 %s 分支", getCurrentBranch(project), getTargetBranch(project));
    }
}


