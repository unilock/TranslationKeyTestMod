# Translation Key Test Mod

Consider the following language file:

```
{
	"key.with.no.args": "Key with no args...",
	"key.with.one.arg": "Key with one arg, %s!",
	"key.with.no.args.again": "hello"
}
```

...and a command that prints the following to both chat and the game log:

```
Text.translatable("key.with.no.args")
Text.translatable("key.with.one.arg", Text.translatable("key.with.no.args.again"))
```

Execute `/testcmd`.

In *singleplayer,* the following is printed to chat *and* the client log:

```
Key with no args...
Key with one arg, hello!
```

This is what would be expected.

In *multiplayer,* the following is printed to chat:

```
Key with no args...
Key with one arg, hello!
```

*However,* the following is printed to the server log:

```
key.with.no.args
key.with.one.arg
```

This is *not* correct.

(Note that the client and server must *both* have this mod installed, in order for the language assets to be available on the client.)
