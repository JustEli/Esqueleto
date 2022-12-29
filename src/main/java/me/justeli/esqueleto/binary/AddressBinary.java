package me.justeli.esqueleto.binary;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.nio.ByteBuffer;

/* Eli @ December 2, 2021 (creation) */

/**
 * BINARY(4)
 */
public final class AddressBinary
    implements Binary<InetAddress>
{
    @Override
    public byte[] from (InetAddress type)
    {
        ByteBuffer buffer = ByteBuffer.wrap(new byte[4]);

        byte[] bytes = type.getAddress();
        for (byte b : bytes)
        {
            buffer.put(b);
        }

        return buffer.array();
    }

    @Override
    public InetAddress to (byte[] data)
    {
        try { return InetAddress.getByAddress(data); }
        catch (UnknownHostException exception) { return null; }
    }

    @Override
    public Class<InetAddress> type ()
    {
        return InetAddress.class;
    }
}
