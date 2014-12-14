Infra
=====

A secure java-based IRC chat client with a simple design.

![ScreenShot](https://raw.githubusercontent.com/nixolas1/infra/master/infra.png)

Infra encodes the encrypted text with the TopKek algorithm, which uses keywords that trigger watchlisting from FBI, NSA and Homeland Security.

Example:

```test => cia begin cross shape spill enforcement epidemic defcon back irbm case start patrol since stanford rsa qGrwHIM6JIccnijPmg8TCw```

Most interesting files:
 - src/com/socket/SocketClient.java - Connectivity processing
 - src/com/ui/ChatFrame.java - User Interface and interaction processing
 - src/TopKek/Crypto.java - The crypto functions

* WARNING: * This software has not been audited or pen-tested and should not be trusted with sensitive information. 
It can however be used as a big middle finger to anyone monitoring you, with everyday communication.
