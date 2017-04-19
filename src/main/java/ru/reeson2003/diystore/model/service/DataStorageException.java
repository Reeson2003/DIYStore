package ru.reeson2003.diystore.model.service;

/**
 * Date: 18.04.2017.
 * Time: 23:07.
 *
 * @author Pavel Gavrilov.
 */
public class DataStorageException extends Exception {
    public DataStorageException(Throwable throwable) {
        super(throwable);
    }
    public DataStorageException(){}
}
