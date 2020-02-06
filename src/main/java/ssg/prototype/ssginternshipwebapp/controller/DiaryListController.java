package ssg.prototype.ssginternshipwebapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import ssg.prototype.ssginternshipwebapp.domain.Diary;
import ssg.prototype.ssginternshipwebapp.repository.DiaryListRepository;

@Controller
@RequestMapping("/")
public class DiaryListController {

    private static final String user="inhwa";

    private DiaryListRepository diaryListRepository;

    @Autowired
    public DiaryListController(DiaryListRepository diaryListRepository) {
        this.diaryListRepository = diaryListRepository;
    }

    @RequestMapping(method= RequestMethod.GET)
    public String usersDiarys(Model model) {
        List<Diary> diaryList = diaryListRepository.findByUser(user);
        if (diaryList != null) {
            model.addAttribute("diarys", diaryList);
        }
        return "diaryList";
    }

    @RequestMapping(method = RequestMethod.POST)
    public String addToReadingList(Diary diary) {
        diary.setUser(user);
        diaryListRepository.save(diary);
        return "redirect:/";
    }
}