# Yocto

## 07 Variable Assignment

### What are you going to learn?

In this Video we are goin to learn about Types of Variable Assignments.

### Types of Variable Assignments

* **?=**   : This is used to assign the default value to varibale. It can be overridden.
* **??=** : This is used to assign the default value to varibale. But it is a weak assignment. It can be overridden. If multiple assignments are done with this type, the the last one will be considered.
* **=**   : This is a simple variable assignment. It requires " " and spaces are significant. But variables are expanded at the end.
* **:=** : This is an immediate variable expansion. The value assigned is expanded immediately.
* **+=** : This appends a value to a variable. The operator inserts **a space** between the current value and appended value. It takes effect immediately.
* **=+** : This prepends a value to a variable, The operator inserts **a space** between the current value and prepended value. It takes effect immediately.
* **.=** :  This appends a value to a variable. The operator inserts **no space** between the current value and appended value. It takes effect immediately.
* **=.** : This prepends a value to a variable. The operator inserts **no space** between the current value and prepended value. It takes effect immediately.
* **:append** :  This appends a value to a variable. The operator inserts **no space** between the current value and appended value.  The effects are applied at variable expansion time rather than being immediately applied.
* **:prepend** :  This appends a value to a variable. The operator inserts **no space** between the current value and appended value. The effects are applied at variable expansion time rather than being immediately applied.
* **:remove** : This remove values from lists. Specifying a value for removal causes all occurrences of that value to be removed from the variable.



### How to Read Variable Value 

```bash
bitbake -e <RECIPE_NAME> | grep ^<VARIABLE_NAME>=
```



### Assignment Type ?= 

```bitbake
TEST ?= "foo"
TEST ?= "bar"
TEST ?= "val"
TEST ?= "var"

# The final value is TEST="foo" 
```

### Assignment Type ??= 

```bitbake
TEST ??= "foo"
TEST ??= "bar"
TEST ??= "val"
TEST ??= "var"

# The final value is TEST="var" 
```

```bitbake
TEST ??= "foo"
TEST ?= "bar"
TEST ?= "val"
TEST ??= "var"

# The final value is TEST="bar" 
```

### Assignment Type = 

```bitbake
# Override
A ?= "foo"
A = "bar"

# The final value is A="bar" 

# Variable Expansion
A = "foo"
B = "${A}"
A = "bar"

# The final value is B="bar" 
```

### Assignment Type := 

```bitbake
# Override
A ?= "foo"
A := "bar"

# The final value is A="bar" 

# Variable Expansion
A = "foo"
B := "${A}"
A = "bar"
# The final value is B="foo" 
```

### Assignment Type +=  and =+

```bitbake
# Spaces are added here

# Append
A = "foo"
A += "bar"

# The final value is A="foo bar" 

# Prepend
B = "foo"
B =+ "bar"

# The final value is B="bar foo"

# Append
A ?= "val"
A += "var"

# The final value is A="var"

# Prepend
B ??= "val"
B =+ "var"

# The final value is B="var"
```

### Assignment Type .=  and =.

```bitbake
# No Spaces are added here
# Needs to add extra space

# Append
A = "foo"
A .= "bar"

# The final value is A="foobar" 

# Prepend
B = "foo"
B =. "bar"

# The final value is B="barfoo"
```

### Assignment Type :append, :prepend and :remove

```bitbake
# No Spaces are added here
# Needs to add extra space
# Parsed at the end

# Append
A = "foo"
A:append = "bar"
# The final value is A="foobar" 

# Append
A = "foo"
A:append = "bar"
A += "val"
# The final value is A="foo valbar" 

# Append
A = "foo"
A:append = " bar"
# The final value is A="foo bar" 


# Prepend
A = "foo"
A:prepend = "bar"
# The final value is A="barfoo" 

# Prepend
A = "foo"
A:prepend = "bar"
A =+ "val"
# The final value is A="barval foo" 

# Prepend
A = "foo"
A:prepend = "bar "
# The final value is A="bar foo" 

#remove

A = "foo bar"
A:remove = "foo"
# The final value is A=" bar" 

A = "foo bar"
A:remove = "var"
A += "var"
# The final value is A=" foo bar val" 
```





### Reference Link

https://docs.yoctoproject.org/bitbake/2.2/bitbake-user-manual/bitbake-user-manual-metadata.html

### End

In the next video we will learn about how to create a simple recipe.
