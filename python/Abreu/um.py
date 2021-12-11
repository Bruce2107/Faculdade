import numpy as np
import lib as bb
import scipy.constants
import matplotlib.pyplot as plt

x1 = 20621.3 * 1000
x2 = 34642.3* 1000
x3 = 21168.5* 1000
y1 = 5214.2009061* 1000
y2 = 3201.7095080* 1000
y3 = 5193.6201775* 1000

M = np.array([[x1**2,x1,1,y1**2],[x2**2,x2,1,y2**2],[x3**2,x3,1,y3**2]],dtype=np.float32)

A,B,C = bb.gauss(M)

##print (A)
##print (B)
##print (C)
##print('')
xc = -B/(2*A)
a = np.sqrt((xc**2-(C/A)))
b = a*np.sqrt(-A)
e =np.sqrt(1-(b**2/a**2))
f = a * e

v = np.linspace(0, 2*np.pi, 100)
plt.plot( xc+a*np.cos(v) , b*np.sin(v) )


print (xc)
print (a)
print (b)
print (e)
print (f)

G=6.67408e-11
Mterra=5.972e24
P=2*np.pi*(((a**3)/(G*Mterra))**0.5)

print (P)

t = np.linspace(0,P,30)
#print(t)

M = np.zeros(30)

M = (2*np.pi/P)*t[:]

#print (M)

def anonE(x,m):
    return x - e*np.sin (x) - m

E = np.zeros(30)
for i in range (30):
    E[i] = bb.bisseccao(anonE,M[i],0,2*np.pi)
##print (E)

theta = np.zeros(30)
theta = 2*np.arctan(np.sqrt((1+e)/(1-e))*np.tan(E[:]/2))

##print (theta)

r = np.zeros(30)
r = a*((1-e**2)/(1+e*np.cos(theta[:])))
##print (r)

x = np.zeros(30)
x = r[:]*np.cos(theta[:])+xc+f
y = np.zeros(30)
y = r[:]*np.sin(theta[:])


plt.figure(1)
plt.subplot(2,1,1)
plt.plot(xc+a*np.cos(v) , b*np.sin(v))
plt.plot((xc+f),0,'.b',ms=10)
plt.grid(True)
plt.subplot(2,1,2)
plt.plot(x,y,'.r')
plt.plot((xc+f),0,'.b',ms=10)
plt.grid(True)
plt.show()