package practice;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PhoneBook {

    Map<String, String> phoneBook = new TreeMap<>();
    String message;
    String empty = "";

    public static boolean isName(String input) {
        String regexName = "[А-Яа-я]+";
        Pattern pattern = Pattern.compile(regexName);
        Matcher matcher = pattern.matcher(input);
        return matcher.lookingAt();
    }

    public boolean isPhone(String input) {
        String regexPhone = "\\d{11}";
        Pattern pattern1 = Pattern.compile(regexPhone);
        Matcher matcher1 = pattern1.matcher(input);
        return matcher1.lookingAt();
    }

    public void addContact(String phone, String name) {
        if (!isName(name) || !isPhone(phone)) {
            message = "Неверный формат ввода";
        } else if (phoneBook.containsValue(phone)) {
            phoneBook.remove(getName(phone));
            phoneBook.put(name, phone);
        } else if (phoneBook.containsKey(name)) {
            phoneBook.put(name, getPhone(name) + ", " + phone);
        }
        else {
            phoneBook.put(name, phone);
        }
        // проверьте корректность формата имени и телефона
        // (рекомедуется написать отдельные методы для проверки является строка именем/телефоном)
        // если такой номер уже есть в списке, то перезаписать имя абонента
    }

    public String getContactByPhone(String phone) {
        for (Map.Entry<String, String> entry : phoneBook.entrySet()) {
            if (entry.getValue().equals(phone)) {
                return entry.getKey() + " - " + entry.getValue();
            }
        }
        // формат одного контакта "Имя - Телефон"
        // если контакт не найдены - вернуть пустую строку
        return empty;
    }

    public Set<String> getContactByName(String name) {
        TreeSet<String> contactsByName = new TreeSet<>();
        for (Map.Entry<String, String> entry : phoneBook.entrySet()) {
            if (entry.getKey().equals(name)) {
                String contact = entry.getKey() + " - " + entry.getValue();
                contactsByName.add(contact);
            } else {
                contactsByName.isEmpty();
            }
        }
        // формат одного контакта "Имя - Телефон"
        // если контакт не найден - вернуть пустой TreeSet
        return contactsByName;
    }

    public Set<String> getAllContacts() {
        TreeSet<String> allContacts = new TreeSet<>();
        for (Map.Entry<String, String> entry : phoneBook.entrySet()) {
            if (entry.getKey().equals(empty) || entry.getValue().equals(empty)) {
               allContacts.isEmpty();
            } else {
                allContacts.add(entry.getKey() + " - " + entry.getValue());
            }
        }
        // формат одного контакта "Имя - Телефон"
        // если контактов нет в телефонной книге - вернуть пустой TreeSet
        return allContacts;
    }

    public String getName(String phone) {
        for (Map.Entry<String, String> entry : phoneBook.entrySet()) {
            if (entry.getValue().contains(phone)) {
                return entry.getKey();
            }
        }
        return "";
    }

    public String getPhone(String name) {
        for (Map.Entry<String, String> entry : phoneBook.entrySet()) {
            if (entry.getKey().contains(name)) {
                return entry.getValue();
            }
        }
        return empty;
    }

    // для обхода Map используйте получение пары ключ->значение Map.Entry<String,String>
    // это поможет вам найти все ключи (key) по значению (value)
    /*
        for (Map.Entry<String, String> entry : map.entrySet()){
            String key = entry.getKey(); // получения ключа
            String value = entry.getValue(); // получения ключа
        }
    */
}