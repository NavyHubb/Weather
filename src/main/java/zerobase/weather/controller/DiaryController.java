package zerobase.weather.controller;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.RequiredArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;
import zerobase.weather.domain.Diary;
import zerobase.weather.service.DiaryService;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class DiaryController {
    private final DiaryService diaryService;

    @ApiOperation(value = "일기 텍스트와 날씨를 이용해서 DB에 일기 저장", notes = "입력한 날짜에 해당하는 서울 날씨가 함께 저장됩니다.")
    @PostMapping("/create/diary")
    public void createDiary(
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) @ApiParam(value = "날짜 형식: yyyy-MM-dd", example = "2023-01-15") LocalDate date,
            @RequestBody String text) {
        diaryService.createDiary(date, text);
    }

    @ApiOperation("특정 날짜의 모든 일기 데이터를 조회")
    @GetMapping("/read/diary")
    public List<Diary> readDiary(
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) @ApiParam(value = "날짜 형식: yyyy-MM-dd", example = "2023-01-15")LocalDate date) {
        return diaryService.readDiary(date);
    }

    @ApiOperation("선택한 기간 중의 모든 일기 데이터를 조회")
    @GetMapping("/read/diaries")
    public List<Diary> readDiaries(
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) @ApiParam(value = "날짜 형식: yyyy-MM-dd", example = "2023-01-15") LocalDate startDate,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) @ApiParam(value = "날짜 형식: yyyy-MM-dd", example = "2023-01-15") LocalDate endDate) {
        return diaryService.readDiaries(startDate, endDate);
    }

    @ApiOperation("특정 날짜의 첫번째 일기 데이터를 수정")
    @PutMapping("/update/diary")
    public void updateDiary(
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) @ApiParam(value = "날짜 형식: yyyy-MM-dd", example = "2023-01-15") LocalDate date,
            @RequestBody String text) {
        diaryService.updateDiary(date, text);
    }

    @ApiOperation("특정 날짜의 모든 일기 데이터를 삭제")
    @DeleteMapping("/delete/diary")
    public void deleteDiary(
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) @ApiParam(value = "날짜 형식: yyyy-MM-dd", example = "2023-01-15") LocalDate date) {
        diaryService.deleteDiary(date);
    }

}
