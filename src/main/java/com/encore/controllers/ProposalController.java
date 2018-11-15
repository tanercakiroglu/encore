package com.encore.controllers;

import com.encore.entities.Project;
import com.encore.entities.Proposal;
import com.encore.icontrollers.IProposalController;
import com.encore.iservices.IProjectService;
import com.encore.iservices.IProposalService;
import com.mysql.cj.x.protobuf.MysqlxDatatypes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
public class ProposalController implements IProposalController {

    @Autowired
    private IProposalService proposalService;

    @Autowired
    private IProjectService projectService;

    @Override
    public ModelAndView proposalView(HttpServletRequest request, HttpServletResponse response) {
        ModelAndView model = new ModelAndView();
        List<Proposal> proposals = proposalService.getAllProposal();
        request.getSession().setAttribute("proposals",proposals);
        model.addObject("proposals",proposals);
        return new ModelAndView("secured/proposal","model",model);
    }

    @Override
    public ModelAndView proposalAddUpdateView(@RequestParam(value = "proposalId", required = false) String proposalId,HttpServletRequest request, HttpServletResponse response) {
        ModelAndView model = new ModelAndView();
        List<Project> projects =projectService.getAllProjects();
        model.addObject("projects",getSelectItemsProjects(projects));
        if(proposalId!=null) {
            List<Proposal> proposals = (List<Proposal>) request.getSession().getAttribute("proposals");
            Optional<Proposal> selectedProposal=proposals.stream().filter(x->x.getId()==Long.valueOf(proposalId)).findFirst();
            model.addObject("selectedProposal",selectedProposal.isPresent()? selectedProposal.get():null);
        }
        return new ModelAndView("secured/proposalAddOrUpdate","model",model);
    }

    Map<Long,String> getSelectItemsProjects(  List<Project> list){
        Map<Long,String> map = new HashMap<>();
        for(Project item :list ){
            map.put(item.getId(),item.getProjectName());
        }
        return map;
    }
}
