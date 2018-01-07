package eu.servermanager.dev.spigot.utils;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ConnectException;
import java.net.InetSocketAddress;
import java.net.Socket;

public class PingServer
{
    private String host = null;
    private int port = 0;
    private Socket socket = new Socket();
    private String[] data = new String['?'];
    private boolean isOnline;

    public PingServer(String host, int port)
    {
        this.host = host;
        this.port = port;
        try
        {
            try
            {
                this.socket.connect(new InetSocketAddress(host, port));
            }
            catch (ConnectException ex)
            {
                this.isOnline = false;
                return;
            }
            this.isOnline = true;
            OutputStream out = this.socket.getOutputStream();
            InputStream in = this.socket.getInputStream();
            out.write(254);

            StringBuffer str = new StringBuffer();
            int b;
            while ((b = in.read()) != -1) {
                if ((b != 0) && (b > 16) && (b != 255) && (b != 23) && (b != 24)) {
                    str.append((char)b);
                }
            }
            this.data = str.toString().split("�");
            this.data[0] = this.data[0].substring(1, this.data[0].length());
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }

    public String getMotd()
    {
        return this.data[0];
    }

    public Integer getOnline()
    {
        return Integer.valueOf(Integer.parseInt(this.data[1]));
    }

    public Integer getMax()
    {
        return Integer.valueOf(Integer.parseInt(this.data[2]));
    }

    public void update()
    {
        try
        {
            this.socket.close();
            this.socket = new Socket();
            try
            {
                this.socket.connect(new InetSocketAddress(this.host, this.port));
            }
            catch (ConnectException ex)
            {
                this.isOnline = false;
                return;
            }
            this.isOnline = true;

            OutputStream out = this.socket.getOutputStream();
            InputStream in = this.socket.getInputStream();
            out.write(254);

            StringBuffer str = new StringBuffer();
            int b;
            while ((b = in.read()) != -1) {
                if ((b != 0) && (b > 16) && (b != 255) && (b != 23) && (b != 24)) {
                    str.append((char)b);
                }
            }
            this.data = str.toString().split("�");
            this.data[0] = this.data[0].substring(1, this.data[0].length());
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }

    public boolean isOnline()
    {
        return this.isOnline;
    }
}
