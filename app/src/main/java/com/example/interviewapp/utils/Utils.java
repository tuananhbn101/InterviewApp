package com.example.interviewapp.utils;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Environment;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.WindowManager;

import androidx.databinding.DataBindingUtil;

import com.example.interviewapp.R;
import com.example.interviewapp.data.Candidate;
import com.example.interviewapp.data.CandidateSkill;
import com.example.interviewapp.data.Skill;
import com.example.interviewapp.databinding.DialogAnswerBinding;
import com.google.gson.Gson;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.CellStyle;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Utils {
    public static String getJsonFromAssets(Context context) {
        String json;
        try {
            InputStream inputStream = context.getAssets().open("skill_android.json");
            int size = inputStream.available();
            byte[] buffer = new byte[size];
            inputStream.read(buffer);
            inputStream.close();
            json = new String(buffer, StandardCharsets.UTF_8);
        } catch (IOException ex) {
            ex.printStackTrace();
            return null;
        }
        return json;
    }
    public static HSSFSheet createSheet(HSSFWorkbook hssfWorkbook,String sheetName,List<CandidateSkill> candidateSkillList){
        CellStyle cellStyle = hssfWorkbook.createCellStyle();
        cellStyle.setFillForegroundColor(HSSFColor.AQUA.index);
        cellStyle.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);
        cellStyle.setAlignment(CellStyle.ALIGN_CENTER);
        CellStyle cellStyleContent = hssfWorkbook.createCellStyle();
        cellStyleContent.setAlignment(CellStyle.ALIGN_LEFT);
        cellStyleContent.setWrapText(true);
        HSSFSheet hssfSheet = hssfWorkbook.createSheet(sheetName);
        hssfSheet.setColumnWidth(0, 5000);
        hssfSheet.setColumnWidth(1, 3000);
        hssfSheet.setColumnWidth(2, 10000);
        hssfSheet.setColumnWidth(3, 10000);
        HSSFRow row = hssfSheet.createRow(0);
        HSSFCell cell;
        cell = row.createCell(0);
        cell.setCellValue("Kỹ năng");
        cell.setCellStyle(cellStyle);

        cell = row.createCell(1);
        cell.setCellValue("Level");
        cell.setCellStyle(cellStyle);

        cell = row.createCell(2);
        cell.setCellValue("Các kỹ năng biết");
        cell.setCellStyle(cellStyle);

        cell = row.createCell(3);
        cell.setCellValue("Các kỹ năng chưa biết");
        cell.setCellStyle(cellStyle);

        for (int i = 0; i < candidateSkillList.size(); i++) {
            // Create a New Row for every new entry in list
            HSSFRow rowData = hssfSheet.createRow(i + 1);

            cell = rowData.createCell(0);
            cell.setCellValue(candidateSkillList.get(i).getGeneralSkill());
            cell.setCellStyle(cellStyleContent);

            cell = rowData.createCell(1);
            cell.setCellValue(candidateSkillList.get(i).getLevel());
            cell.setCellStyle(cellStyleContent);
            cell = rowData.createCell(2);
            cell.setCellValue(candidateSkillList.get(i).getKnownSkills().toString());
            cell.setCellStyle(cellStyleContent);
            cell = rowData.createCell(3);
            cell.setCellValue(candidateSkillList.get(i).getUnknownSkills().toString());
            cell.setCellStyle(cellStyleContent);
        }
        return hssfSheet;
    }
    public static HSSFWorkbook createExcelSheet(List<CandidateSkill> candidateSkillList,String sheetName) {

        HSSFWorkbook hssfWorkbook = new HSSFWorkbook();
        createSheet(hssfWorkbook,sheetName,candidateSkillList);
        return hssfWorkbook;
    }
    public static void exportCandidateFile(String sheetName,List<CandidateSkill> candidateSkillList){
        FileOutputStream fileOutputStream;
        File filePath = new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOCUMENTS) + "/" + sheetName + ".xls");
        if (!filePath.exists()) {
            try {
                filePath.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        try {
            fileOutputStream = new FileOutputStream(filePath);
            Utils.createExcelSheet(candidateSkillList,sheetName).write(fileOutputStream);
            fileOutputStream.flush();
            fileOutputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void shareFile(Context context,String fileName){
        File file = new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOCUMENTS) + "/" + fileName + ".xls");
        Intent shareIntent = new Intent();
        shareIntent.setAction(Intent.ACTION_SEND);
        shareIntent.putExtra(Intent.EXTRA_STREAM,Uri.parse(file.getAbsolutePath()));
        shareIntent.setType("application/xls");
        context.startActivity(Intent.createChooser(shareIntent, null));
    }
    public static void showDialogAnswer(Activity activity, String title, String content){
        Dialog answerDialog = new Dialog(activity);
        DialogAnswerBinding binding = DataBindingUtil.inflate(LayoutInflater.from(activity), R.layout.dialog_answer,null,false);
        answerDialog.setContentView(binding.getRoot());
        binding.tileTextview.setText(title);
        binding.cancelImageview.setOnClickListener(v -> answerDialog.cancel());
        binding.contentTextview.setText(content);
        answerDialog.show();
        DisplayMetrics displayMetrics = new DisplayMetrics();
        activity.getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        int displayWidth = displayMetrics.widthPixels;
        int displayHeight = displayMetrics.heightPixels;
        WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();
        layoutParams.copyFrom(answerDialog.getWindow().getAttributes());
        int dialogWindowWidth = (int) (displayWidth * 0.9f);
        int dialogWindowHeight = (int) (displayHeight * 0.9f);
        layoutParams.width = dialogWindowWidth;
        layoutParams.height = dialogWindowHeight;
        answerDialog.getWindow().setAttributes(layoutParams);
    }
    public static String convertFormSkillListToString(List<CandidateSkill> candidateSkills){
        StringBuilder content = new StringBuilder();
        for (CandidateSkill candidateSkill: candidateSkills
             ) {
            content.append(candidateSkill.getGeneralSkill()).append(": ").append(candidateSkill.getKnownSkills()).append("\n");
        }
        return content.toString();
    }
    public static HSSFWorkbook createMultipleSheet(List<Candidate> candidateList,String sheetName){
        HSSFWorkbook hssfWorkbook = new HSSFWorkbook();
        for (Candidate candidate: candidateList
             ) {

            createSheet(hssfWorkbook,candidate.getName(),convertStringToCandidateSkillList(candidate.getCandidateSkills()));
        }
        return hssfWorkbook;
    }
    public static void exportFile(String sheetName,List<Candidate> candidateList){
        FileOutputStream fileOutputStream;
        File filePath = new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOCUMENTS) + "/" + sheetName + ".xls");
        if (!filePath.exists()) {
            try {
                filePath.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        try {
            fileOutputStream = new FileOutputStream(filePath);
            Utils.createMultipleSheet(candidateList,sheetName).write(fileOutputStream);
            fileOutputStream.flush();
            fileOutputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static List<CandidateSkill> convertStringToCandidateSkillList(String candidateSkillListString){
        Gson gson = new Gson();
        List<CandidateSkill> candidateSkillList = gson.fromJson(candidateSkillListString, ArrayList.class);
        return candidateSkillList;
    }
    public static String convertCandidateSkillListToString(List<CandidateSkill> candidateSkillList){
        String candidateSkillString = "";
        for (CandidateSkill candidateSkill: candidateSkillList
             ) {
            candidateSkillString += candidateSkill.getGeneralSkill()+"("+candidateSkill.getLevel()+") :";
            for (Skill skill: candidateSkill.getKnownSkills()
                 ) {
                candidateSkillString+="\n\t"+skill.getSkill();
            }
        }
        return candidateSkillString;
    }
}
