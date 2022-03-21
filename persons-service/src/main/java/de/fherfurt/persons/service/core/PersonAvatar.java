package de.fherfurt.persons.service.core;

import de.fherfurt.persons.service.persistence.PersonAvatarRepository;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

/**
 * @author Tran Anh Hoang
 * The Class PersonAvatar has the main goal to convert an image into an ByteArray
 * and save it into an Avatar-Repository
 */
public class PersonAvatar
{
    private byte [] avatarByteArray;

    /**
     * @param imagePath - absolute Path to the Image
     * @return Byte-Array of an Image
     * @throws IOException -
     */
    public byte[] convertImageToByteArray(String imagePath) throws IOException {
        try{
            File userAvatar = new File(imagePath);
            return this.avatarByteArray = Files.readAllBytes(userAvatar.toPath());
        }
        catch (IOException ioe){
            System.out.println("Image Error:" + ioe.getMessage());
            throw ioe;
        }
    }

    /**
     * puts the avatar into AvatarRepository
     * @param personId identification of a person
     */
    public void setAvatarByteArrayIntoAvatarRepositoryBy(int personId) {
        PersonAvatarRepository.getInstance().saveAvatarBy(personId, avatarByteArray);
    }
}
