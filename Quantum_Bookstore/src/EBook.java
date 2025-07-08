public class EBook extends Book {
    private String fileExtension;
    private double fileSize;
    private String downloadLink;
    private boolean isDownloadable;

    public EBook() {
    }

    public EBook(int ISBN, String bookName, String authorName, String publisherName, String yearOfPublish, double price, int quantity, String fileExtension, double fileSize, boolean isDownloadable) {
        super(ISBN, bookName, authorName, publisherName, yearOfPublish, price, quantity, false);
        this.fileExtension = fileExtension;
        this.fileSize = fileSize;
        this.downloadLink = generateDownloadLink();
        this.isDownloadable = isDownloadable;
    }

    private String generateDownloadLink()
    {
        return "https://SFS-Quabtum-BookStore.com/download/" + super.getBookISBN() + "." + super.getBookName() + '.' + fileExtension;
    }

    public String getFileExtension() {
        return fileExtension;
    }
    public void setFileExtension(String fileExtension) {
        this.fileExtension = fileExtension;
    }

    public double getFileSize() {
        return fileSize;
    }
    public void setFileSize(double fileSize) {
        this.fileSize = fileSize;
    }

    public String getDownloadLink() {
        return downloadLink;
    }

    public boolean isDownloadable() {
        return isDownloadable;
    }

    public void setDownloadable(boolean downloadable) {
        isDownloadable = downloadable;
    }

    @Override
    public String toString() {
        return super.toString()
                + " '\', Book Type = EBook{"
                + "fileExtension='" + fileExtension + '\''
                + ", fileSize=" + fileSize
                + ", downloadLink='" + downloadLink + '\''
                + ", isDownloadable=" + isDownloadable
                + "}";
    }
}
